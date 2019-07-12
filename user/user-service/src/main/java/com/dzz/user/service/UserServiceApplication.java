package com.dzz.user.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 用户服务
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月12 13:43
 */
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.dzz.user.service.domain.dao")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
