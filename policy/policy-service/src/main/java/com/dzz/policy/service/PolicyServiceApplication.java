package com.dzz.policy.service;

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
 * @since 2019年08月08 10:28
 */
@SpringBootApplication
@EnableOAuth2Client
@EnableEurekaClient
@MapperScan("com.dzz.policy.service.domain.dao")
public class PolicyServiceApplication {

    /**
     * 启动类
     * @param args args
     */
    public static void main(String[] args) {

        SpringApplication.run(PolicyServiceApplication.class, args);
    }
}
