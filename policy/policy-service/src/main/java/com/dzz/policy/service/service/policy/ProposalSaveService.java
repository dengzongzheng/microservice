package com.dzz.policy.service.service.policy;

import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.util.response.ResponsePack;

/**
 * 投保单保存接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月20 13:37
 */
public interface ProposalSaveService {

    /**
     * 投保单保存
     * @param saveParam param
     * @return 处理结果，返回其中的投保单号
     */
    ResponsePack<String> savePolicy(PolicyCommonSaveParam saveParam);
}
