package com.dzz.policy.api.service;

import com.dzz.policy.api.config.PolicyServiceFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 图形短信验证码接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 17:34
 */
@FeignClient(name = "policy-service", configuration = PolicyServiceFeignConfiguration.class)
public interface ImageSmsCodeService {


}