package com.dzz.user.api.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 用户详情BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 21:45
 */
@Data
@ApiModel(description = "用户详情BO")
public class UserDetailBo implements Serializable {

    private static final long serialVersionUID = -4937079185960886243L;

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "保单号")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "用户权限")
    private List<UserAuthorityBo> authorities;
}
