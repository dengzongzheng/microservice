package com.dzz.gateway.routers;

import com.dzz.gateway.config.CommonProperties;
import com.dzz.gateway.filter.TimingFilter;
import com.dzz.gateway.limiter.RateLimitByIpGatewayFilter;
import java.time.Duration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.RestController;

/**
 * 路由处理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年07月11 18:12
 */
@RestController
public class Router {

    @Autowired
    private ReactiveRedisTemplate<String,String> redisTemplate;

    @Autowired
    private CommonProperties commonProperties;


    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                //policy_service_route
                .route("policy_service_route", r -> r.path("/api/hello/**")
                        .filters(f -> f.hystrix(
                                config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
//                        .filters(f -> f.requestRateLimiter()
//                                .configure(c -> c.setRateLimiter(getRedisRateLimiter())))
                        .uri("lb://POLICY-SERVICE")
                        .filter(new TimingFilter())
                        .filters(new RateLimitByIpGatewayFilter(10, 1, Duration.ofSeconds(1)))
                        .order(1)
                        .id("policy-service-router"))
                //权限服务
                .route("authority_service_route", r -> r.path("/oauth/**")
                        .filters(f -> f.hystrix(
                                config -> config.setName("mycmd2").setFallbackUri("forward:/authorityFallback")))
//                        .filters(f -> f.requestRateLimiter()
//                                .configure(c -> c.setRateLimiter(getRedisRateLimiter())))
                        .uri(commonProperties.getAuthorityUrl())
                        .filter(new TimingFilter())
                        .filters(new RateLimitByIpGatewayFilter(10, 1, Duration.ofSeconds(1)))
                        .order(2)
                        .id("authority-router"))
                .build();

    }

    @Bean
    public RateLimitByIpGatewayFilter hostAddrKeyResolver() {
        return new RateLimitByIpGatewayFilter();
    }

    @Bean
    public RedisRateLimiter getRedisRateLimiter() {

        return new RedisRateLimiter(100,2);
    }
}
