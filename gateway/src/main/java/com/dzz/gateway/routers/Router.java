package com.dzz.gateway.routers;

import com.dzz.gateway.filter.TimingFilter;
import com.dzz.gateway.limiter.HostAddrKeyResolver;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
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

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("policy_service_route", r -> r.path("/api/hello/**")
                        .filters(f -> f.hystrix(
                                config -> config.setName("mycmd").setFallbackUri("forward:/fallback")))
//                        .uri("lb://POLICY-SERVICE")
                        .uri("http://127.0.0.1:7002")
                        .filter(new TimingFilter())
                        .order(1)
                        .id("policy-service-router"))
                .build();

    }

    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
