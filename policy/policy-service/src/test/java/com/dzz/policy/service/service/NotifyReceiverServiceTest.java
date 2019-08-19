package com.dzz.policy.service.service;

import com.dzz.policy.service.service.common.EncryptToolsService;
import com.dzz.policy.service.service.notify.NotifyReceiverService;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 14:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class NotifyReceiverServiceTest extends TestCase {

    @Autowired
    private NotifyReceiverService notifyReceiverService;

    @Autowired
    private EncryptToolsService encryptToolsService;

    @Test
    public void testPayNotifyHandler() {

        String paySign = "test-pay-sign";
        String paySignResult = encryptToolsService.encrypt(paySign);

        log.info("处理结果为:{}",notifyReceiverService.payNotifyHandler(paySignResult));
    }
}