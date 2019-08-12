package com.dzz.user.service.controller;

import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.domain.bo.UserListBo;
import com.dzz.user.api.domain.dto.UserListParam;
import com.dzz.user.api.domain.dto.UserSaveParam;
import com.dzz.user.api.service.UserService;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.dzz.util.validate.ValidateResultHandler;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 17:44
 */
@RestController
@Api(value = "用户接口", tags = "用户接口API")
@Slf4j
public class UserController{

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * 保存用户
     *
     * @param saveParam 参数
     * @return 保存结果
     */
    @PostMapping(UserService.SAVE_USER_URL)
    public ResponsePack<Boolean> saveUser(@RequestBody @Validated UserSaveParam saveParam,
            BindingResult bindingResult) {

        ValidateResultHandler.bindResultHandler(bindingResult);
        return userService.saveUser(saveParam);
    }

    /**
     * 用户列表查询
     *
     * @param listParam 参数
     * @return 结果
     */
    @PostMapping(UserService.LIST_USER)
    public ResponsePack<PageUtil<UserListBo>> listUser(@RequestBody UserListParam listParam) {

        return userService.listUser(listParam);
    }


    /**
     * 用户详情查询
     *
     * @param userName 用户名
     * @return 结果
     */
    @GetMapping(UserService.DETAIL_USER)
    public ResponsePack<UserDetailBo> detailUser(@RequestParam("userName") String userName) {

        return userService.detailUser(userName);
    }

}
