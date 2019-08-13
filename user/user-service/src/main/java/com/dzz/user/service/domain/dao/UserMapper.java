package com.dzz.user.service.domain.dao;

import com.dzz.user.api.domain.bo.UserDetailBo;
import com.dzz.user.api.domain.bo.UserListBo;
import com.dzz.user.api.domain.dto.UserListParam;
import com.dzz.user.service.domain.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author dzz
 */
public interface UserMapper extends Mapper<User> {

    /**
     * 用户列表查询
     * @param listParam 查询条件
     * @return 结果
     */
    List<UserListBo> listUser(@Param("param") UserListParam listParam);


    /**
     * 用户详情查询
     * @param userName 用户名
     * @return 返回结果
     */
    UserDetailBo detailUser(@Param("userName") String userName);
}