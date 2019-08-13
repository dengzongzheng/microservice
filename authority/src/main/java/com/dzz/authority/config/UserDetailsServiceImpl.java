package com.dzz.authority.config;

import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.service.UserService;
import com.dzz.util.response.ResponsePack;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月08 11:28
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        ResponsePack<UserDetailBo> responsePack = userService.detailUser(username);
        if(responsePack.checkFail() || null == responsePack.getData()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        UserDetailBo userDetailBo = responsePack.getData();
        return User.builder().username(userDetailBo.getUserName()).password(userDetailBo.getPassword())
                .authorities(userDetailBo.getAuthorities().stream().map(s -> new Authority(s.getAuthority())).collect(
                        Collectors.toList())).build();
    }
}
