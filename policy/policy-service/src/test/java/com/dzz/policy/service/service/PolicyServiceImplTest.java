package com.dzz.policy.service.service;

import com.dzz.policy.api.service.PolicyService;
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
 * @since 2019年08月19 09:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class PolicyServiceImplTest extends TestCase {

    @Autowired
    private PolicyService policyService;

    @Test
    public void testSavePolicy() {

    }

    @Test
    public void testListPolicy() {

    }

    @Test
    public void testDetailPolicy() {

    }

    @Test
    public void testApplyInsuranceService() {

        log.info("返回结果为:{}", policyService.applyInsuranceService("P123456789"));
    }

    @Test
    public void testSendInsurance() {

    }
}