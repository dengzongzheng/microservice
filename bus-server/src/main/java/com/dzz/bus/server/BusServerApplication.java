package com.dzz.bus.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 消息总线
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月12 10:26
 */
@SpringBootApplication
public class BusServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BusServerApplication.class, args);
    }

}
