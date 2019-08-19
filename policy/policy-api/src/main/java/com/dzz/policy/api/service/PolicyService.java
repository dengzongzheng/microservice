package com.dzz.policy.api.service;

import com.dzz.policy.api.config.PolicyServiceFeignConfiguration;
import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyInsuranceDataUpdateParam;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.api.domain.dto.PolicyPayDataUpdateParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.api.domain.dto.PolicyStatusUpdateParam;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * demo 接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 09:52
 */
@FeignClient(name = "policy-service", configuration = PolicyServiceFeignConfiguration.class)
public interface PolicyService {

    String BASE_URL = "/api/policy";

    String SAVE_POLICY_URL = BASE_URL + "/savePolicy";

    String LIST_POLICY = BASE_URL + "/listPolicy";

    String DETAIL_POLICY = BASE_URL + "/detailPolicy";

    String GET_POLICY_STATUS = BASE_URL + "/getPolicyStatus";

    String UPDATE_POLICY_STATUS = BASE_URL + "/updatePolicyStatus";


    String UPDATE_POLICY_PAY_DATA = BASE_URL + "/updatePolicyPayData";

    /**
     * 保存policy
     * @param saveParam 参数
     * @return 保存结果
     */
    @PostMapping(SAVE_POLICY_URL)
    ResponsePack<Boolean> savePolicy(@RequestBody PolicyCommonSaveParam saveParam);

    /**
     * 列表policy查询
     * @param listParam 参数
     * @return 结果
     */
    @PostMapping(LIST_POLICY)
    ResponsePack<PageUtil<PolicyListBo>> listPolicy(@RequestBody PolicyListParam listParam);


    /**
     * policy 详情查询
     * @param policyNo 保单号
     * @return 结果
     */
    @GetMapping(DETAIL_POLICY)
    ResponsePack<PolicyDetailBo> detailPolicy(@RequestParam("policyNo") String policyNo);


    /**
     * 获取投保单状态
     * @param proposalNo 投保单号
     * @return 状态
     */
    @GetMapping(GET_POLICY_STATUS)
    ResponsePack<Integer> getPolicyStatus(@RequestParam("proposalNo") String proposalNo);


    /**
     * 更新投保单状态
     * @param param param
     * @return 更新结果
     */
    @PostMapping(UPDATE_POLICY_STATUS)
    ResponsePack<Boolean> updatePolicyStatus(@RequestBody PolicyStatusUpdateParam param);


    /**
     * 更新投保单状态
     * @param param param
     * @return 更新结果
     */
    @PostMapping(UPDATE_POLICY_STATUS)
    ResponsePack<Boolean> updatePolicyInsuranceData(@RequestBody PolicyInsuranceDataUpdateParam param);


    /**
     * 更新投保单支付相关信息
     * @param param param
     * @return 更新结果
     */
    @PostMapping(UPDATE_POLICY_PAY_DATA)
    ResponsePack<Boolean> updatePolicyPayData(@RequestBody PolicyPayDataUpdateParam param);


    /**
     * 取保险公司代码
     * @param proposalNo 投保单号
     * @return 保险公司代码
     */
    ResponsePack<String> getProposalInsuranceCode(@RequestParam("proposalNo") String proposalNo);
}
