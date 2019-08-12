package com.dzz.user.api.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 保存Policy Param
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 21:44
 */
@Data
@ApiModel(description = "保存用户 Param")
public class UserSaveParam implements Serializable {

    private static final long serialVersionUID = 1187329096714882368L;

    @ApiModelProperty(value = "用户名")
    private String userName;


    @ApiModelProperty(value = "密码")
    private String password;


    @ApiModelProperty(value = "用户权限")
    private List<UserAuthorityParam> authorities;

}
