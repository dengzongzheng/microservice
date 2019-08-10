package com.dzz.util.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 分页包装类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年04月24 22:56
 */
@Data
@ApiModel(description = "分页数据统一封装")
public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = -8419082543496293641L;


    @ApiModelProperty(value = "页号")
    private Integer pageNo = 1;


    @ApiModelProperty(value = "总条数")
    private Integer totalCount;


    @ApiModelProperty(value = "总页数")
    private Integer totalPage;


    @ApiModelProperty(value = "每页条数")
    private Integer pageSize = 10;


    @ApiModelProperty(value = "数据")
    private List<T> data;

    public void setTotalCount(Long totalCount) {
        this.totalCount = Math.toIntExact(totalCount);
    }

    /**
     * 计算一共多少页
     */
    public void setTotalPage() {
        if (this.totalCount == 0) {
            this.totalPage = 0;
        } else {
            this.totalPage =
                    (this.totalCount % this.pageSize > 0) ? (this.totalCount / this.pageSize + 1)
                            : this.totalCount / this.pageSize;
        }
    }

}
