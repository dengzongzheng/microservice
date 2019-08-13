package com.dzz.user.service.service;

import com.dzz.user.api.domain.dto.UserAuthorityParam;
import com.dzz.user.api.domain.dto.UserSaveParam;
import com.dzz.user.service.domain.model.User;
import com.dzz.user.service.domain.model.UserAuthority;
import com.dzz.util.id.IdService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * bean 转换工具
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月13 09:21
 */
@Service
public class BeanConvertService {


    private IdService idService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setIdService(IdService idService) {
        this.idService = idService;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 转换成User
     * @param saveParam param
     * @return User 对象
     */
    public User convertToUser(UserSaveParam saveParam) {

        User user = new User();
        BeanUtils.copyProperties(saveParam, user);
        user.setId(idService.getId());
        user.setPassword(passwordEncoder.encode(saveParam.getPassword()));
        return user;
    }

    /**
     * 转换成UserAuthority列表
     * @param authorities authorities
     * @param userId 用户Id
     * @return UserAuthority列表
     */
    public List<UserAuthority> convertToUserAuthority(List<UserAuthorityParam> authorities,Long userId) {

        return authorities.stream().map(s -> {
            UserAuthority userAuthority = new UserAuthority();
            BeanUtils.copyProperties(s, userAuthority);
            userAuthority.setUserId(userId);
            return userAuthority;
        }).collect(Collectors.toList());
    }
}
