package com.dzz.policy.service.controller.common;

import com.dzz.policy.service.service.notify.NotifyReceiverService;
import com.dzz.util.response.ResponsePack;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知接收器Controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 11:44
 */
@RestController
@Api(value = "通知接收接口API", tags = "通知接收接口API")
@Slf4j
public class NotifyReceiverController {

    private NotifyReceiverService notifyReceiverService;

    @Autowired
    public void setNotifyReceiverService(NotifyReceiverService notifyReceiverService) {
        this.notifyReceiverService = notifyReceiverService;
    }

    /**
     * 支付成功回调
     * @param paySign 密文
     * @return 结果
     */
    @ApiOperation(value = "支付成功回调接口", notes = "支付成功回调接口")
    @ApiImplicitParam(name = "paySign", value = "密文", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = "/policy/paySuccessNotify", method = {RequestMethod.GET, RequestMethod.POST})
    @ApiResponse(response = ResponsePack.class,code = 1,  message = "接口调用成功")
    public String paySuccessNotify(@RequestParam("paySign") String paySign) {

        return notifyReceiverService.payNotifyHandler(paySign);
    }
}
