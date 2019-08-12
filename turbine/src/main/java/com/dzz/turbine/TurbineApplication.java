package com.dzz.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 启动类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 09:34
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
@EnableDiscoveryClient
public class TurbineApplication {

    /**
     * 启动方法
     * @param args 参数
     */
    public static void main(String[] args) {

        SpringApplication.run(TurbineApplication.class, args);
    }
}
