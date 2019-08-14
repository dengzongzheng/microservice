package com.dzz.gateway.hystrix;

import com.dzz.util.response.ResponsePack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 熔断
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 15:09
 */
@RestController
@Slf4j
public class FallbackController {

    @GetMapping("/fallback")
    public Mono<ResponsePack> fallback() {

        log.warn("网关转发调用异常，触发熔断");
        return Mono.just(ResponsePack.fail("fall back"));
    }

    @GetMapping("/authorityFallback")
    public ResponsePack<?> authorityFallback() {

        log.info("网关转发授权认证应用调用异常，触发熔断");
        return ResponsePack.fail("服务开小差请稍后再试");
    }
}
