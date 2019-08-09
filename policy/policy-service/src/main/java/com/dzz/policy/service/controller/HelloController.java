package com.dzz.policy.service.controller;

import com.dzz.policy.service.controller.common.url.HelloUrlConstants;
import com.dzz.policy.service.domain.dao.PolicyMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
public class HelloController extends BaseController{

    private PolicyMapper policyMapper;

    @Autowired
    public void setPolicyMapper(PolicyMapper policyMapper) {
        this.policyMapper = policyMapper;
    }

    @GetMapping(HelloUrlConstants.SAY_HELLO)
    @ApiOperation(value = "say hello接口", notes = "say hello接口")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "String", paramType = "query")
    public ResponseEntity<?> sayHello(String name) throws InterruptedException {

        policyMapper.selectAll().forEach(s->{
            System.out.println(s.getPolicyNo());
        });
        TimeUnit.SECONDS.sleep(3);
        return ResponseEntity.ok(name + " hello");
    }
}
