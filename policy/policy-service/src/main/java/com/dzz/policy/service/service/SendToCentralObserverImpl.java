package com.dzz.policy.service.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 发送核心
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月14 16:57
 */
@Slf4j
@Component
public class SendToCentralObserverImpl implements Observer {

    @Override
    public void apply(String proposalNo) {
        log.info("发送核心接收到发送通知,投保单号为:{}", proposalNo);
    }
}
