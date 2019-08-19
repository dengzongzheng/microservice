package com.dzz.policy.service.controller;

import com.dzz.policy.service.service.pay.PolicyPayService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 支付Controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 15:01
 */
@RestController
@Api(value = "支付接口API", tags = "支付接口API")
@Slf4j
public class PolicyPayController {

    @Autowired
    private PolicyPayService policyPayService;
}
