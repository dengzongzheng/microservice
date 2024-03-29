package com.dzz.user.service.service;

import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.domain.bo.UserListBo;
import com.dzz.user.api.domain.dto.UserListParam;
import com.dzz.user.api.domain.dto.UserSaveParam;
import com.dzz.user.api.service.UserService;
import com.dzz.user.service.domain.dao.UserAuthorityMapper;
import com.dzz.user.service.domain.dao.UserMapper;
import com.dzz.user.service.domain.model.User;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户接口实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 17:59
 */
@Service
@SuppressWarnings("ALL")
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;


    private UserAuthorityMapper userAuthorityMapper;


    private BeanToolsService beanToolsService;


    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserAuthorityMapper(UserAuthorityMapper userAuthorityMapper) {
        this.userAuthorityMapper = userAuthorityMapper;
    }

    @Autowired
    public void setBeanConvertService(BeanToolsService beanConvertService) {
        this.beanToolsService = beanConvertService;
    }



    @Override
    @Transactional(rollbackForClassName = {"Exception.class"})
    public ResponsePack<Boolean> saveUser(UserSaveParam saveParam) {

        User user = beanToolsService.convertToUser(saveParam);
        userMapper.insert(user);
        userAuthorityMapper
                .batchInsert(beanToolsService.convertToUserAuthority(saveParam.getAuthorities(), user.getId()));
        return ResponsePack.ok(Boolean.TRUE);
    }

    @Override
    public ResponsePack<PageUtil<UserListBo>> listUser(UserListParam listParam) {

        PageHelper.startPage(listParam.getPageNo(), listParam.getPageSize(), true);
        PageUtil<UserListBo> pageUtil = new PageUtil<>();
        List<UserListBo> listUser = userMapper.listUser(listParam);
        PageInfo<UserListBo> pageInfo = new PageInfo<>(listUser);
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponsePack.ok(pageUtil);
    }

    @Override
    public ResponsePack<UserDetailBo> detailUser(String userName) {

        return ResponsePack.ok(userMapper.detailUser(userName));
    }

}
