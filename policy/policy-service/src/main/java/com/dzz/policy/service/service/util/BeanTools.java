package com.dzz.policy.service.service.util;

import com.dzz.policy.api.domain.dto.PolicySaveParam;
import com.dzz.policy.service.domain.model.Policy;
import org.springframework.beans.BeanUtils;

/**
 * bean 转换工具
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月10 07:01
 */
public class BeanTools {

    /**
     * 转换成Policy
     * @param saveParam param
     * @return policy 实体
     */
    public static Policy convertToPolicy(PolicySaveParam saveParam) {

        Policy policy = new Policy();
        BeanUtils.copyProperties(saveParam, policy);
        return policy;
    }
}
