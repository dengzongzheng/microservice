package com.dzz.user.service.config.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * 公共配置
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月12 13:45
 */
@Configuration
@RefreshScope
@Data
public class CommonConfig {

    @Value("${user.name}")
    private String userName;


    @Value("${user.password}")
    private String password;

}
