package com.dzz.policy.api.domain.dto;

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
@ApiModel(description = "保存Policy Param")
public class PolicyCommonSaveParam implements Serializable {

    private static final long serialVersionUID = 1187329096714882368L;

    @ApiModelProperty(value = "保单号")
    private String policyNo;

    @ApiModelProperty(value = "保险公司投保单号")
    private String insuranceProposalNo;

    @ApiModelProperty(value = "投保人")
    private PolicyCommonHolderSaveParam holder;


    @ApiModelProperty(value = "保被保险人")
    private List<PolicyCommonSubjectSaveParam> subjects;
}
