package com.dzz.user.api.config;

import feign.Request;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * FeignClient Config
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 22:04
 */
@Component
public class UserServiceFeignConfiguration {

    @Bean
    public Retryer feignRetryer() {/*feign client 失败不重试*/
        return new Retryer.Default(100,1,0);
    }

    @Bean
    Request.Options feignOptions() {/*feign client 超时时间设置*/
        return new Request.Options(10000, 10 * 60 * 1000);
    }

}
