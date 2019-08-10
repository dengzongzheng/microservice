package com.dzz.policy.api.domain.dto;

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
@ApiModel(description = "数据返回统一封装")
public class PolicySaveParam implements Serializable {

    private static final long serialVersionUID = 1187329096714882368L;

    @ApiModelProperty(value = "标志code 1:成功、2:失败")
    private String policyNo;
}
