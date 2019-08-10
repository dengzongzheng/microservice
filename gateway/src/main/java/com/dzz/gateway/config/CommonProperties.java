package com.dzz.gateway.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 配置文件
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月10 23:34
 */
@Configuration
@Data
public class CommonProperties {

    @Value("${authority.host}")
    private String authorityUrl;

}
