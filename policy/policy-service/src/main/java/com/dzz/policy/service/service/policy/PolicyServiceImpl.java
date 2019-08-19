package com.dzz.policy.service.service.policy;

import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyInsuranceDataUpdateParam;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.api.domain.dto.PolicyPayDataUpdateParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.api.domain.dto.PolicyStatusUpdateParam;
import com.dzz.policy.api.service.PolicyService;
import com.dzz.policy.service.domain.dao.PolicyMapper;
import com.dzz.policy.service.domain.model.Policy;
import com.dzz.policy.service.service.common.BeanToolsService;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DemoService 实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 22:10
 */
@Service
@Slf4j
@SuppressWarnings("ALL")
public class PolicyServiceImpl implements PolicyService {

    private PolicyMapper policyMapper;

    @Autowired
    private BeanToolsService beanToolsService;


    @Autowired
    public void setPolicyMapper(PolicyMapper policyMapper) {
        this.policyMapper = policyMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponsePack<Boolean> savePolicy(PolicyCommonSaveParam saveParam) {

        Policy policy = beanToolsService.convertToPolicy(saveParam);
        return ResponsePack.ok(policyMapper.insert(policy)>0);
    }

    @Override
    public ResponsePack<PageUtil<PolicyListBo>> listPolicy(PolicyListParam listParam) {

        PageHelper.startPage(listParam.getPageNo(), listParam.getPageSize(), true);
        PageUtil<PolicyListBo> pageUtil = new PageUtil<>();
        List<PolicyListBo> listPolicy = policyMapper.listPolicy(listParam);
        PageInfo<PolicyListBo> pageInfo = new PageInfo<>(listPolicy);
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponsePack.ok(pageUtil);
    }

    @Override
    public ResponsePack<PolicyDetailBo> detailPolicy(String policyNo) {

        return ResponsePack.ok(policyMapper.detailPolicy(policyNo));
    }

    @Override
    public ResponsePack<Integer> getPolicyStatus(String proposalNo) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponsePack<Boolean> updatePolicyStatus(PolicyStatusUpdateParam param) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponsePack<Boolean> updatePolicyInsuranceData(PolicyInsuranceDataUpdateParam param) {
        return null;
    }

    @Override
    public ResponsePack<Boolean> updatePolicyPayData(PolicyPayDataUpdateParam param) {

        return null;
    }

    @Override
    public ResponsePack<String> getProposalInsuranceCode(String proposalNo) {

        return ResponsePack.ok("cpic");
    }

}
