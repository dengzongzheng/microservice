package com.dzz.authority.config;

import com.alibaba.fastjson.JSON;
import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.service.UserService;
import com.dzz.util.response.ResponsePack;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月13 11:55
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void detailUser() {

        ResponsePack<UserDetailBo> responsePack = userService.detailUser("admin");
        log.info("{}", JSON.toJSONString(responsePack));
    }
}