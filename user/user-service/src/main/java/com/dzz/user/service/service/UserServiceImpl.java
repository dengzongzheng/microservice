package com.dzz.user.service.service;

import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.domain.bo.UserListBo;
import com.dzz.user.api.domain.dto.UserListParam;
import com.dzz.user.api.domain.dto.UserSaveParam;
import com.dzz.user.api.service.UserService;
import com.dzz.user.service.domain.dao.UserAuthorityMapper;
import com.dzz.user.service.domain.dao.UserMapper;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 17:59
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;


    private UserAuthorityMapper userAuthorityMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserAuthorityMapper(UserAuthorityMapper userAuthorityMapper) {
        this.userAuthorityMapper = userAuthorityMapper;
    }

    @Override
    public ResponsePack<Boolean> saveUser(UserSaveParam saveParam) {
        return null;
    }

    @Override
    public ResponsePack<PageUtil<UserListBo>> listUser(UserListParam listParam) {
        return null;
    }

    @Override
    public ResponsePack<UserDetailBo> detailUser(String userName) {
        return null;
    }
}
