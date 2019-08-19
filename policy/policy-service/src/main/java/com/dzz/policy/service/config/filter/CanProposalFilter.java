package com.dzz.policy.service.config.filter;

import com.dzz.policy.service.config.exception.BusinessException;
import java.io.IOException;
import java.time.LocalTime;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

/**
 * 是否允许投保Filter
 * 拦截晚上23:45后的投保
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 18:16
 */
@WebFilter(filterName="CanProposalFilter",urlPatterns="/api/product/*")
@Slf4j
public class CanProposalFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        LocalTime localTime = LocalTime.now();
        int hour = 23;
        int minute = 45;
        if(localTime.isAfter(LocalTime.of(hour, minute))) {
            log.info("拦截了{}请求,超过当天最晚投保时间{}:{}", httpServletRequest.getRequestURL(), hour, minute);
            throw new BusinessException("超过当天最晚投保时间，请明天再来哦");
        }
        chain.doFilter(request, response);
    }
}
