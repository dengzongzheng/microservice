package com.dzz.policy.api.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 保单状态更新参数
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 15:19
 */
@Data
@ApiModel(description = "保单状态更新 Param")
public class PolicyStatusUpdateParam {

    @ApiModelProperty(value = "投保单号")
    private String proposalNo;

    @ApiModelProperty(value = "投保单状态")
    private Integer status;
}
