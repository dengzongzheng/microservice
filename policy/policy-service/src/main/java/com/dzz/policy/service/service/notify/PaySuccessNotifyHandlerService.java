package com.dzz.policy.service.service.notify;

import com.dzz.policy.api.domain.dto.PolicyPayDataUpdateParam;
import com.dzz.policy.api.service.PolicyService;
import com.dzz.util.response.ResponsePack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 支付成功处理接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 13:44
 */
@Service
@Slf4j
@SuppressWarnings("ALL")
public class PaySuccessNotifyHandlerService {


    private PolicyService policyService;

    @Autowired
    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    /**
     * 支付成功处理接口,更新投保单支付状态等信息
     * @param decodeSign 已经解密后的数据
     * @return 处理结果
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponsePack<Boolean> paySuccessHandler(String decodeSign) {

        PolicyPayDataUpdateParam payDataUpdateParam = new PolicyPayDataUpdateParam();
        return policyService.updatePolicyPayData(payDataUpdateParam);
    }
}
