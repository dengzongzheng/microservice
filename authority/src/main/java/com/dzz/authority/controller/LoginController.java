package com.dzz.authority.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月10 21:17
 */
@RestController
@RequestMapping("/authority/api")
@Slf4j
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;


//    @Autowired
//    private OAuth2AuthenticationManager oAuth2AuthenticationManager;

    /**
     * 用户登录
     *
     * @return 登录结果
     */
    @GetMapping("/login")
    public String login() {

        try {


        } catch (AuthenticationException e) {
           e.printStackTrace();
        }
        return "success";
    }
}
