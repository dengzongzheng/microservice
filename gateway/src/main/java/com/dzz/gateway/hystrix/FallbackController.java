package com.dzz.gateway.hystrix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String fallback() {
        return "Hello World!\nfrom gateway";
    }

}
