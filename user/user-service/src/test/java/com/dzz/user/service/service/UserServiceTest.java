package com.dzz.user.service.service;

import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.domain.bo.UserListBo;
import com.dzz.user.api.domain.dto.UserAuthorityParam;
import com.dzz.user.api.domain.dto.UserListParam;
import com.dzz.user.api.domain.dto.UserSaveParam;
import com.dzz.user.api.service.UserService;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 21:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
public class UserServiceTest {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Test
    public void saveUser() {
        UserSaveParam userSaveParam = new UserSaveParam();
        userSaveParam.setUserName("admin1");
        userSaveParam.setPassword("123456");
        userSaveParam
                .setAuthorities(Lists.newArrayList(new UserAuthorityParam("/test1"), new UserAuthorityParam("/test2")));
        userService.saveUser(userSaveParam);
    }

    @Test
    public void listUser() {

        UserListParam userListParam = new UserListParam();
        userListParam.setPageNo(1);
        userListParam.setPageSize(10);
        ResponsePack<PageUtil<UserListBo>> responsePack = userService.listUser(userListParam);
        assert responsePack.checkSuccess();
        responsePack.getData().getData().forEach(System.out::println);
    }

    @Test
    public void detailUser() {

        ResponsePack<UserDetailBo> responsePack = userService.detailUser("admin");
        assert responsePack.checkSuccess();
        System.out.println(responsePack.getData());
    }

}
