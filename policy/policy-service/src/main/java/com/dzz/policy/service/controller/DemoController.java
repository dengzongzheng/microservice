package com.dzz.policy.service.controller;

import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.api.domain.dto.PolicySaveParam;
import com.dzz.policy.api.service.DemoService;
import com.dzz.policy.service.controller.common.url.HelloUrlConstants;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import java.util.concurrent.TimeUnit;
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
 * demo controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月08 10:35
 */
@RestController
@Api(value = "示例代码API", tags = "示例代码API")
@Slf4j
public class DemoController extends BaseController{

    private DemoService demoService;

    @Autowired
    public void setDemoService(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping(HelloUrlConstants.SAY_HELLO)
    @ApiOperation(value = "say hello接口", notes = "say hello接口")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "query")
    @PreAuthorize("hasAuthority('"+HelloUrlConstants.SAY_HELLO+"')")
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<?> sayHello(String name) throws InterruptedException {

        TimeUnit.SECONDS.sleep(3);
        return ResponsePack.ok(name + " hello");
    }

    /**
     * 保存policy
     *
     * @param saveParam 参数
     * @return 保存结果
     */
    @PostMapping(DemoService.SAVE_POLICY_URL)
    @ApiOperation(value = "保存policy接口", notes = "保存policy")
    @ApiImplicitParam(name = "saveParam", value = "保存policy实体类参数", required = true, dataType = "PolicySaveParam")
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<Boolean> savePolicy(@RequestBody @Validated PolicySaveParam saveParam,
            BindingResult bindingResult) {

        bindResultHandler(bindingResult);
        return demoService.savePolicy(saveParam);
    }

    /**
     * 列表policy查询
     * @param listParam 参数
     * @return 结果
     */
    @ApiOperation(value = "列表policy查询接口", notes = "列表policy查询")
    @PostMapping(DemoService.LIST_POLICY)
    @ApiImplicitParam(name = "listParam", value = "列表policy查询参数", required = true, dataType = "PolicyListParam")
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<PageUtil<PolicyListBo>> listPolicy(@RequestBody @Validated PolicyListParam listParam,
            BindingResult bindingResult) {

        bindResultHandler(bindingResult);
        return demoService.listPolicy(listParam);
    }

    /**
     * policy 详情查询
     * @param policyNo 保单号
     * @return 结果
     */
    @ApiOperation(value = "policy 详情查询接口", notes = "policy 详情查询")
    @ApiImplicitParam(name = "policyNo", value = "保单号", required = true, dataType = "String", paramType = "query")
    @GetMapping(DemoService.DETAIL_POLICY)
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public ResponsePack<PolicyDetailBo> detailPolicy(@RequestParam("policyNo") String policyNo) {

        return demoService.detailPolicy(policyNo);
    }
}
