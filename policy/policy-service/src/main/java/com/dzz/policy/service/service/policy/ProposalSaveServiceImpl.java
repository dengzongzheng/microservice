package com.dzz.policy.service.service.policy;

import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.service.domain.dao.PolicyMapper;
import com.dzz.policy.service.domain.model.Policy;
import com.dzz.util.id.IdService;
import com.dzz.util.response.ResponsePack;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 投保单保存接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月20 13:38
 */
@Slf4j
@Service
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ProposalSaveServiceImpl implements ProposalSaveService{

    private IdService idService;

    private PolicyMapper policyMapper;

    @Autowired
    public void setIdService(IdService idService) {
        this.idService = idService;
    }

    @Autowired
    public void setPolicyMapper(PolicyMapper policyMapper) {
        this.policyMapper = policyMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponsePack<String> savePolicy(PolicyCommonSaveParam saveParam) {

        Policy policy = policyTransformer.apply(saveParam);
        int count = policyMapper.insert(policy);
        return count > 0 ? ResponsePack.ok(policy.getPolicyNo()) : ResponsePack.fail("保存失败");
    }

    private Function<PolicyCommonSaveParam, Policy> policyTransformer = (param) -> {

        Policy policy = new Policy();
        policy.setId(idService.getId());
        policy.setPolicyNo(param.getPolicyNo());
        return policy;
    };


}
