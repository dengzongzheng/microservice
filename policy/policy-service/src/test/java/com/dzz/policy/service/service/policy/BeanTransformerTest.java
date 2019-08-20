package com.dzz.policy.service.service.policy;

import com.alibaba.fastjson.JSON;
import com.dzz.policy.api.domain.dto.PolicyCommonHolderSaveParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSubjectSaveParam;
import com.dzz.policy.service.domain.model.Policy;
import com.google.common.collect.Lists;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月20 10:32
 */
public class BeanTransformerTest extends TestCase {


    @Test
    public void testTransform() {

        PolicyCommonSaveParam policyCommonSaveParam = new PolicyCommonSaveParam();
        PolicyCommonHolderSaveParam policyCommonHolderSaveParam = new PolicyCommonHolderSaveParam();
        PolicyCommonSubjectSaveParam policyCommonSubjectSaveParam = new PolicyCommonSubjectSaveParam();
        policyCommonSaveParam.setHolder(policyCommonHolderSaveParam);
        policyCommonSaveParam.setSubjects(Lists.newArrayList(policyCommonSubjectSaveParam));
        policyCommonSaveParam.setPolicyNo("123123123123");
        TestFunction testFunction = new TestFunction();
        Policy policy = testFunction.function.apply(policyCommonSaveParam);
        System.out.println(JSON.toJSONString(policy));
    }

//    private Function<PolicyCommonSaveParam, Policy> function = (param) -> {
//        Policy policy = new Policy();
//        policy.setPolicyNo(param.getPolicyNo());
//        return policy;
//    };
}