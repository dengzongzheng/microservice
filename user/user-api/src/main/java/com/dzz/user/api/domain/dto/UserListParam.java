package com.dzz.user.api.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户列表查询 Param
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 21:45
 */
@Data
@ApiModel(description = "用户列表查询条件")
public class UserListParam implements Serializable {

    private static final long serialVersionUID = 7858479680847918094L;


    @ApiModelProperty(value = "页号")
    private Integer pageNo = 1;

    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "查询条件")
    private String content;
}
