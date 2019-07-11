package com.dzz.user.service.config.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * 用户配置信息
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月11 15:47
 */
@Component
@Data
@RefreshScope
public class UserConfig {

    @Value("${user.name}")
    private String userName;

    @Value("${user.password}")
    private String password;

}
