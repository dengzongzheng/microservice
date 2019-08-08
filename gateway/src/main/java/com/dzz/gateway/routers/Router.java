package com.dzz.gateway.routers;

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
                .route("path_route", r -> r.path("/api/hello/**")
                        .uri("lb://POLICY-SERVICE")
                        .order(1)
                        .id("policy-service-router"))
                .build();

    }
}
