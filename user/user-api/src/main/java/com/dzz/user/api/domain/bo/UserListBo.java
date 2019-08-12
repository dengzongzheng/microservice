package com.dzz.user.api.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户列表 BO
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 21:45
 */
@Data
@ApiModel(description = "用户列表BO")
public class UserListBo implements Serializable {

    private static final long serialVersionUID = -4937079185960886243L;

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "用户密码")
    private String userName;
}
