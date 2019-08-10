package com.dzz.policy.service.service;

import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.api.domain.dto.PolicySaveParam;
import com.dzz.policy.api.service.DemoService;
import com.dzz.policy.service.domain.dao.PolicyMapper;
import com.dzz.policy.service.domain.model.Policy;
import com.dzz.policy.service.service.util.BeanTools;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoService 实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 22:10
 */
@Service
public class DemoServiceImpl implements DemoService {

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
    public ResponsePack<Boolean> savePolicy(PolicySaveParam saveParam) {

        Policy policy = BeanTools.convertToPolicy(saveParam);
        policy.setId(idService.getId());

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
}
