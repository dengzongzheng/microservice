package com.dzz.authority.config;

import com.dzz.user.api.service.UserService;
import com.google.common.collect.Lists;
import java.util.List;
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

//        ResponsePack<UserDetailBo> responsePack = userService.detailUser(username);
//        if(responsePack.checkFail() || null == responsePack.getData()) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        UserDetailBo userDetailBo = responsePack.getData();
//        return User.builder().username(userDetailBo.getUserName()).password(userDetailBo.getPassword())
//                .authorities(userDetailBo.getAuthorities().stream().map(s -> new Authority(s.getAuthority())).collect(
//                        Collectors.toList())).build();
//        ResponsePack<UserDetailBo> responsePack = userService.detailUser(username);
        return mockUser(username);
    }

    private UserDetails mockUser(String username) {
        String userName = "user";
        String userPass = "123456";

//        if (!userName.equals(username)) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }

        // this is another way of dealing with password encoding
        // password will be stored in bcrypt in this example
        // you can also use a prefix, @see com.patternmatch.oauth2blog.config.AuthorizationServerConfig#CLIENT_SECRET
        UserDetails user = User.builder()
                .username(username)
                .password(userPass)
                .authorities(getAuthority())
                .build();

        return user;
    }

    private List<Authority> getAuthority() {

        return Lists.newArrayList(new Authority("/api/hello"));
    }
}
