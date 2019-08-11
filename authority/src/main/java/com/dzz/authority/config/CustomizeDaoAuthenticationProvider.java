package com.dzz.authority.config;

import com.alibaba.fastjson.JSON;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月11 10:13
 */
@Slf4j
public class CustomizeDaoAuthenticationProvider extends DaoAuthenticationProvider {


    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails,
            UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        log.info("取到的参数为:{}", JSON.toJSONString(authentication.getDetails()));

        Map<String, String> param = (LinkedHashMap<String, String>) authentication.getDetails();
        if("phone".equals(param.get("type"))) {
            if (authentication.getCredentials() == null) {
                logger.debug("Authentication failed: no credentials provided");

                throw new BadCredentialsException(messages.getMessage(
                        "AbstractUserDetailsAuthenticationProvider.badCredentials",
                        "Bad credentials"));
            }

            String presentedPassword = authentication.getCredentials().toString();

            if(!"1000".equals(param.get("smsCode"))) {
                throw new BadCredentialsException(messages.getMessage(
                        "AbstractUserDetailsAuthenticationProvider.badCredentials",
                        "Bad credentials"));
            }
        }else{
            super.additionalAuthenticationChecks(userDetails, authentication);
        }

    }
}
