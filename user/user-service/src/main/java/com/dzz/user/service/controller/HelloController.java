package com.dzz.user.service.controller;

import com.dzz.user.service.config.common.CommonConfig;
import com.dzz.user.service.domain.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月12 13:47
 */
@RestController
@RequestMapping("/api/user")
public class HelloController {

    private CommonConfig commonConfig;


    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setCommonConfig(CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
    }

    @GetMapping("/hello")
    public ResponseEntity sayHello() {

        return ResponseEntity.ok(commonConfig.getUserName() + " say hello!!!");
    }
}
