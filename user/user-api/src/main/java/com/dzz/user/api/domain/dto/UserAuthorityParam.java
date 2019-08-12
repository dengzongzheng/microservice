package com.dzz.user.api.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户权限param
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 17:48
 */
@Data
@ApiModel(description = "用户权限Param")
public class UserAuthorityParam implements Serializable {

    private static final long serialVersionUID = 954934291157210099L;


    @ApiModelProperty(value = "权限")
    private String authority;
}
