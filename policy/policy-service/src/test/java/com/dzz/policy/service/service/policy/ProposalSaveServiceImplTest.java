package com.dzz.policy.service.service.policy;

import com.alibaba.fastjson.JSON;
import com.dzz.policy.api.domain.dto.PolicyCommonHolderSaveParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSubjectSaveParam;
import com.dzz.util.response.ResponsePack;
import com.google.common.collect.Lists;
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
 * @since 2019年08月20 15:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class ProposalSaveServiceImplTest extends TestCase {

    @Autowired
    private ProposalSaveService proposalSaveService;


    @Test
    public void testSavePolicy() {

        PolicyCommonSaveParam policyCommonSaveParam = new PolicyCommonSaveParam();
        PolicyCommonHolderSaveParam policyCommonHolderSaveParam = new PolicyCommonHolderSaveParam();
        PolicyCommonSubjectSaveParam policyCommonSubjectSaveParam = new PolicyCommonSubjectSaveParam();
        policyCommonSaveParam.setHolder(policyCommonHolderSaveParam);
        policyCommonSaveParam.setSubjects(Lists.newArrayList(policyCommonSubjectSaveParam));
        policyCommonSaveParam.setPolicyNo("123123123123");
        ResponsePack responsePack = proposalSaveService.savePolicy(policyCommonSaveParam);
        log.info("返回结果为:{}", JSON.toJSONString(responsePack));
        ResponsePack<String> r = ResponsePack.ok();
    }
}