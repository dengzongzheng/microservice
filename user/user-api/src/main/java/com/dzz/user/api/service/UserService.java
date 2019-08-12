package com.dzz.user.api.service;


import com.dzz.user.api.config.UserServiceFeignConfiguration;
import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.domain.bo.UserListBo;
import com.dzz.user.api.domain.dto.UserListParam;
import com.dzz.user.api.domain.dto.UserSaveParam;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 09:52
 */
@FeignClient(name = "user-service", configuration = UserServiceFeignConfiguration.class)
public interface UserService {

    String BASE_URL = "/api/user";

    String SAVE_USER_URL = BASE_URL + "/saveUser";

    String LIST_USER = BASE_URL + "/listUser";

    String DETAIL_USER = BASE_URL + "/detailUser";

    /**
     * 保存用户
     * @param saveParam 参数
     * @return 保存结果
     */
    @PostMapping(SAVE_USER_URL)
    ResponsePack<Boolean> saveUser(@RequestBody UserSaveParam saveParam);

    /**
     * 用户列表查询
     * @param listParam 参数
     * @return 结果
     */
    @PostMapping(LIST_USER)
    ResponsePack<PageUtil<UserListBo>> listUser(@RequestBody UserListParam listParam);


    /**
     * 用户详情查询
     * @param userName 用户名
     * @return 结果
     */
    @GetMapping(DETAIL_USER)
    ResponsePack<UserDetailBo> detailUser(@RequestParam("userName") String userName);
}
