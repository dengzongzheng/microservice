package com.dzz.policy.service.service.observer;

import com.dzz.policy.api.service.PolicyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 发送运营
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月14 16:59
 */
@Slf4j
@Component
public class SendToBusinessObserverImpl extends AbstractObserver {

    private PolicyService policyService;

    @Autowired
    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    @Async("asyncExecutor")
    @Override
    public void apply(String proposalNo) {
        log.info("发送运营接收到发送通知,投保单号为:{}", proposalNo);
    }
}
