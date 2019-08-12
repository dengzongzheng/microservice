package com.dzz.authority;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 授权服务启动类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月07 20:21
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class AuthorityApplication {

    /**
     * 启动类
     * @param args args
     */
    public static void main(String[] args) {

        SpringApplication.run(AuthorityApplication.class, args);
    }

}
