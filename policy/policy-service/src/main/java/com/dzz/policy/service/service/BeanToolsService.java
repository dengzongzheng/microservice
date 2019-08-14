package com.dzz.policy.service.service;

import com.dzz.policy.api.domain.dto.PolicySaveParam;
import com.dzz.policy.service.domain.model.Policy;
import com.dzz.util.id.IdService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * bean 转换工具
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月13 09:21
 */
@Service
public class BeanToolsService {


    private IdService idService;

    @Autowired
    public void setIdService(IdService idService) {
        this.idService = idService;
    }


    /**
     * 转换成Policy
     * @param saveParam param
     * @return policy 实体
     */
    public Policy convertToPolicy(PolicySaveParam saveParam) {

        Policy policy = new Policy();
        BeanUtils.copyProperties(saveParam, policy);
        policy.setId(idService.getId());
        return policy;
    }
}
