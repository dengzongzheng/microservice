package com.dzz.policy.service.domain.dao;

import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.service.domain.model.Policy;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author dzz
 */
public interface PolicyMapper extends Mapper<Policy> {

    /**
     * 批量插入Policy
     * @param param param
     * @return 插入条数
     */
    Integer batchInsert(@Param("param") List<Policy> param);

    /**
     * Policy 详情
     * @param policyNo 保单号
     * @return 结果
     */
    PolicyDetailBo detailPolicy(@Param("policyNo") String policyNo);

    /**
     * 列表查询
     * @param param 查询条件
     * @return 结果
     */
    List<PolicyListBo> listPolicy(@Param("param") PolicyListParam param);
}