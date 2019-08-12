package com.dzz.user.api.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 保存Policy Param
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 21:44
 */
@Data
@ApiModel(description = "保存Policy Param")
public class PolicySaveParam implements Serializable {

    private static final long serialVersionUID = 1187329096714882368L;

    @ApiModelProperty(value = "保单号")
    private String policyNo;
}
