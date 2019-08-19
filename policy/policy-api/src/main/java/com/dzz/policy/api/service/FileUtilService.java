package com.dzz.policy.api.service;

import com.dzz.policy.api.config.PolicyServiceFeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 文件公共接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 17:31
 */
@FeignClient(name = "policy-service", configuration = PolicyServiceFeignConfiguration.class)
public interface FileUtilService {

}
