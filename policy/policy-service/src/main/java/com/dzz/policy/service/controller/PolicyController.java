package com.dzz.policy.service.controller;

import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.api.service.PolicyService;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.dzz.util.validate.ValidateResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * policy controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月08 10:35
 */
@RestController
@Api(value = "policy接口API", tags = "policy接口API")
@Slf4j
public class PolicyController {

    private PolicyService policyService;

    @Autowired
    public void setDemoService(PolicyService policyService) {
        this.policyService = policyService;
    }


    /**
     * 保存policy
     *
     * @param saveParam 参数
     * @return 保存结果
     */
    @PostMapping(PolicyService.SAVE_POLICY_URL)
    @ApiOperation(value = "保存policy接口", notes = "保存policy")
    @ApiImplicitParam(name = "saveParam", value = "保存policy实体类参数", required = true, dataType = "PolicySaveParam")
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<Boolean> savePolicy(@RequestBody @Validated PolicyCommonSaveParam saveParam,
            BindingResult bindingResult) {

        ValidateResultHandler.bindResultHandler(bindingResult);
        return policyService.savePolicy(saveParam);
    }

    /**
     * 列表policy查询
     * @param listParam 参数
     * @return 结果
     */
    @ApiOperation(value = "列表policy查询接口", notes = "列表policy查询")
    @PostMapping(PolicyService.LIST_POLICY)
    @ApiImplicitParam(name = "listParam", value = "列表policy查询参数", required = true, dataType = "PolicyListParam")
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<PageUtil<PolicyListBo>> listPolicy(@RequestBody @Validated PolicyListParam listParam,
            BindingResult bindingResult) {

        ValidateResultHandler.bindResultHandler(bindingResult);
        return policyService.listPolicy(listParam);
    }

    /**
     * policy 详情查询
     * @param policyNo 保单号
     * @return 结果
     */
    @ApiOperation(value = "policy 详情查询接口", notes = "policy 详情查询")
    @ApiImplicitParam(name = "policyNo", value = "保单号", required = true, dataType = "String", paramType = "query")
    @GetMapping(PolicyService.DETAIL_POLICY)
    @PreAuthorize("hasAuthority('"+PolicyService.DETAIL_POLICY+"')")
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<PolicyDetailBo> detailPolicy(@RequestParam("policyNo") String policyNo) {

        return policyService.detailPolicy(policyNo);
    }
}
