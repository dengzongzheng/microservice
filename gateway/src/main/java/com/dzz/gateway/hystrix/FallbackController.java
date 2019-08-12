package com.dzz.gateway.hystrix;

import com.dzz.util.response.ResponsePack;
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
public class FallbackController {

    @GetMapping("/fallback")
    public Mono<ResponsePack> fallback() {
        return Mono.just(ResponsePack.fail("fall back"));
    }

}
