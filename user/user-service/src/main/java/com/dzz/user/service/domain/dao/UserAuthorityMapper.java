package com.dzz.user.service.domain.dao;

import com.dzz.user.service.domain.model.UserAuthority;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author dzz
 */
public interface UserAuthorityMapper extends Mapper<UserAuthority> {

    /**
     * 批量插入UserAuthority
     * @param param param
     * @return 插入条数
     */
    Integer batchInsert(@Param("param") List<UserAuthority> param);
}