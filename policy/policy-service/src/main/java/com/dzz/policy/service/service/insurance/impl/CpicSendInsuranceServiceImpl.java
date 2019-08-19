package com.dzz.policy.service.service.insurance.impl;

import com.dzz.policy.api.service.PolicyService;
import com.dzz.policy.service.service.observer.Observable;
import com.dzz.policy.service.service.observer.SendToBusinessObserverImpl;
import com.dzz.policy.service.service.observer.SendToCentralObserverImpl;
import com.dzz.policy.service.service.insurance.SendInsuranceService;
import com.dzz.util.response.ResponsePack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * CPIC
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 14:06
 */
@Slf4j
@Component
public class CpicSendInsuranceServiceImpl implements SendInsuranceService {

    private String productCode = "cpic";

    @Autowired
    private SendToBusinessObserverImpl sendToBusinessObserver;

    @Autowired
    private SendToCentralObserverImpl sendToCentralObserver;

    @Autowired
    private PolicyService policyService;

    @Override
    public String getProductCode() {
        return productCode;
    }

    @Override
    public ResponsePack applyPrepareUnderwriting(String proposalNo) {
        return null;
    }

    @Async("asyncExecutor")
    @Override
    public void applyUnderwriting(String proposalNo) {

        log.info("cpic 处理 applyInsuranceService：{}", proposalNo);
        Observable observable = new Observable();
        observable.addObserver(sendToBusinessObserver);
        observable.addObserver(sendToCentralObserver);
        observable.notifyObservers(proposalNo);
    }

    @Override
    public ResponsePack refundUnderwriting(String proposalNo) {
        return null;
    }
}
