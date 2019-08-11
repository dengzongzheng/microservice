package com.dzz.authority.controller;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
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
public class UserController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;


    @GetMapping("/logout")
    public void logout(HttpServletRequest request, String token) {
        consumerTokenServices.revokeToken(token);
    }
}
