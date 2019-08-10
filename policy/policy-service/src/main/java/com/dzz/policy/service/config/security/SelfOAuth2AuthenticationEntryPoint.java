package com.dzz.policy.service.config.security;

import com.alibaba.fastjson.JSON;
import com.dzz.util.response.ResponsePack;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月10 16:36
 */
@Slf4j
public class SelfOAuth2AuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {

        try(PrintWriter out = response.getWriter()){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            out.write(JSON.toJSONString(ResponsePack.fail("权限不足")));
            out.flush();
        }catch(IOException e) {
            log.error("IO异常了", e);
        }
    }
}
