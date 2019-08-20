package com.dzz.policy.service.service.policy;

import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.service.domain.model.Policy;
import java.util.function.Function;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月20 10:49
 */
public class TestFunction {

    public Function<PolicyCommonSaveParam, Policy> function = (param) -> {
        Policy policy = new Policy();
        policy.setPolicyNo(param.getPolicyNo());
        return policy;
    };
}
