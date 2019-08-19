package com.dzz.policy.api.domain.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 间隔时间Bo
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 17:48
 */
@Data
@ApiModel(description = "间隔时间BO")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntervalDateBo implements Serializable {

    private static final long serialVersionUID = 497088856332544738L;

    @ApiModelProperty(value = "开始时间")
    private String startDate;

    @ApiModelProperty(value = "结束时间")
    private String endDate;
}
