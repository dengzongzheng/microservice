package com.dzz.policy.api.service;

import com.dzz.policy.api.config.PolicyServiceFeignConfiguration;
import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.util.response.ResponsePack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * PICC产品相关接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 16:29
 */
@FeignClient(name = "policy-service", configuration = PolicyServiceFeignConfiguration.class)
public interface PiccProductService {

    String BASE_URL = "/api/product/picc/";


    String APPLY_PREPARE_UNDERWRITING_URL = BASE_URL + "applyPrepareUnderwriting";

    /**
     * PICC 核保接口
     * @param param 参数
     * @return 核保结果
     */
    @PostMapping(APPLY_PREPARE_UNDERWRITING_URL)
    ResponsePack applyPrepareUnderwriting(@RequestBody PolicyCommonSaveParam param);
}
