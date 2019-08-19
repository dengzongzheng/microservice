package com.dzz.policy.service.service.notify;

import com.dzz.policy.api.service.PolicyService;
import com.dzz.policy.service.service.common.EncryptToolsService;
import com.dzz.policy.service.service.insurance.SendInsuranceService;
import com.dzz.util.response.ResponsePack;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 通知接收业务处理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 11:51
 */
@Service
@Slf4j
@SuppressWarnings("ALL")
public class NotifyReceiverService {



    private EncryptToolsService encryptToolsService;

    private PaySuccessNotifyHandlerService paySuccessHandlerService;

    private PolicyService policyService;

    @Autowired
    private List<SendInsuranceService> sendInsurancesServices;

    @Autowired
    public void setEncryptToolsService(EncryptToolsService encryptToolsService) {
        this.encryptToolsService = encryptToolsService;
    }

    @Autowired
    public void setPaySuccessHandlerService(PaySuccessNotifyHandlerService paySuccessHandlerService) {
        this.paySuccessHandlerService = paySuccessHandlerService;
    }

    @Autowired
    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    /**
     * 支付回调通知处理
     * @param paySign 密文
     * @return 处理结果
     */
    public String payNotifyHandler(String paySign) {

        log.info("接收到的支付回调加密密文为:{}", paySign);
        String decodeSing = encryptToolsService.decrypt(paySign);
        if(Strings.isNullOrEmpty(decodeSing)) {
            return "ERROR";
        }
        ResponsePack<Boolean> responsePack = paySuccessHandlerService.paySuccessHandler(decodeSing);
        if(responsePack.checkSuccess() && responsePack.getData()) {
            ResponsePack<String> insuranceCodeResponse = policyService.getProposalInsuranceCode(decodeSing);
            if(insuranceCodeResponse.checkSuccess() || Strings.isNullOrEmpty(insuranceCodeResponse.getData())) {
                SendInsuranceService sendInsuranceService = sendInsurancesServices.stream()
                        .filter(s -> s.getProductCode().equals(insuranceCodeResponse.getData())).findFirst().get();
                if(Objects.isNull(sendInsuranceService)) {
                    log.error("投保单号:{},取不到对应保险公司接口实例,请检查投保单表中insurance_code是否正确。", decodeSing);
                }else{
                    sendInsuranceService.applyUnderwriting(decodeSing);
                }
            }
            return "SUCCESS";
        }
        return "ERROR";
    }
}
