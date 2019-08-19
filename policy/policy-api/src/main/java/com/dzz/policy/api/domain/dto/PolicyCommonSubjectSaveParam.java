package com.dzz.policy.api.domain.dto;

import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import lombok.Data;

/**
 * 被保险保存 param
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 16:11
 */
@Data
@ApiModel(description = "保存PolicySubject Param")
public class PolicyCommonSubjectSaveParam implements Serializable {

    private static final long serialVersionUID = 3365888918736770908L;
}
