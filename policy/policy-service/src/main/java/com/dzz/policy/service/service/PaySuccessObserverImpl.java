package com.dzz.policy.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 支付成功
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月14 17:10
 */
@Slf4j
@Component
public class PaySuccessObserverImpl implements Observer{

    @Override
    public void apply(String proposalNo) {
        log.info("支付成功接收到发送通知,投保单号为:{}", proposalNo);
    }
}
