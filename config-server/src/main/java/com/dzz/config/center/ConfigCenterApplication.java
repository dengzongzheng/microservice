package com.dzz.config.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置中心
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月11 11:13
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class ConfigCenterApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConfigCenterApplication.class, args);
    }
}
