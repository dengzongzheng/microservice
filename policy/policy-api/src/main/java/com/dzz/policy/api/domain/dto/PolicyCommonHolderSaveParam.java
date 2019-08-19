package com.dzz.policy.api.domain.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;

/**
 * 通用投保人保存param
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 16:10
 */
@Data
@ApiModel(description = "保存PolicyHolder Param")
public class PolicyCommonHolderSaveParam implements Serializable {

    private static final long serialVersionUID = 2530191940935007166L;
}
