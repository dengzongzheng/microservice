package com.dzz.policy.service.controller.product;

import com.dzz.policy.api.domain.dto.PolicyCommonSaveParam;
import com.dzz.policy.api.service.PiccProductService;
import com.dzz.policy.api.service.PolicyService;
import com.dzz.policy.service.config.exception.BusinessException;
import com.dzz.policy.service.service.insurance.impl.PiccSendInsuranceServiceImpl;
import com.dzz.util.response.ResponsePack;
import com.dzz.util.validate.ValidateResultHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PICC投保Controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 16:20
 */
@RestController
@Api(value = "PICC接口API", tags = "PICC接口API")
@Slf4j
@SuppressWarnings("ALL")
public class PiccProductController {


    private PiccSendInsuranceServiceImpl piccSendInsuranceService;

    private PolicyService policyService;

    @Autowired
    public void setPiccSendInsuranceService(PiccSendInsuranceServiceImpl piccSendInsuranceService) {
        this.piccSendInsuranceService = piccSendInsuranceService;
    }

    @Autowired
    public void setPolicyService(PolicyService policyService) {
        this.policyService = policyService;
    }

    /**
     * 调用核保
     *
     * @param param 投保param
     * @return 核保结果
     */
    @PostMapping(PiccProductService.APPLY_PREPARE_UNDERWRITING_URL)
    @ApiOperation(value = "PICC核保接口", notes = "PICC核保接口")
    @ApiImplicitParam(name = "param", value = "PICC核保接口参数", required = true, dataType = "PolicyCommonSaveParam")
    @ApiResponse(response = ResponsePack.class, code = 1, message = "接口调用成功")
    public ResponsePack applyPrepareUnderwriting(@RequestBody @Validated PolicyCommonSaveParam param,
            BindingResult bindingResult) {

        ValidateResultHandler.bindResultHandler(bindingResult);
        ResponsePack responsePack = piccSendInsuranceService.applyPrepareUnderwriting(param);
        if(responsePack.checkFail()) {
            log.error("核保失败", responsePack.getMessage());
            throw new BusinessException("核保失败,请稍后再试");
        }
        return policyService.savePolicy(param);
    }

}
