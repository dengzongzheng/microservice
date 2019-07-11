package com.dzz.user.service.controller;

import com.dzz.user.service.config.common.UserConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月11 15:53
 */
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private UserConfig userConfig;

    @Autowired
    public void setUserConfig(UserConfig userConfig) {
        this.userConfig = userConfig;
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {

        return ResponseEntity.ok(userConfig.getUserName() + "say  hello!!!");
    }

}
