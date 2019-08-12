package com.dzz.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 15:07
 */
@SpringBootApplication
@EnableOAuth2Client
@EnableEurekaClient
@MapperScan("com.dzz.user.service.domain.dao")
public class UserServiceApplication {

    /**
     * 启动方法
     * @param args args
     */
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
