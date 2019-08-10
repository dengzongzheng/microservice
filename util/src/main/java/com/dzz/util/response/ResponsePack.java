package com.dzz.util.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * 返回实体封装
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 18:08
 */
@ApiModel(description = "数据返回统一封装")
@SuppressWarnings("unchecked")
@Data
public class ResponsePack<E> implements Serializable {

    private static final long serialVersionUID = 802338676225884680L;

    @ApiModelProperty(value = "标志code 1:成功、2:失败")
    private Integer code;

    @ApiModelProperty(value = "结果说明")
    private String message;

    @ApiModelProperty(value = "结果数据")
    private E data;


    public ResponsePack() {
        this.code = 1;
        this.message = "success";
        this.data = null;
    }

    private ResponsePack(Integer code, String message, E data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponsePack(E data) {
        this.code = 1;
        this.message = "success";
        this.data = data;
    }

    /**
     * 构造封装
     * @param code 标志code 1:成功、2:失败也可以是其他
     * @param message 说明
     * @param data 数据
     * @return 结果
     */
    public static<E> ResponsePack build(Integer code, String message, Object data) {
        return new ResponsePack(code, message, data);
    }

    /**
     * 构造成功带数据的封装
     * @param data 数据
     * @return 结果
     */
    public static<E> ResponsePack ok(Object data) {
        return new ResponsePack(data);
    }

    /**
     * 构建成功的封装
     * @return 结果
     */
    public static<E> ResponsePack ok() {
        return new ResponsePack(null);
    }

    /**
     * 构建只有标志位与说明的封装
     * @param code  标志code 1:成功、2:失败也可以是其他
     * @param message 结果说明
     * @return 结果
     */
    public static<E> ResponsePack build(Integer code, String message) {

        return new ResponsePack(code, message, null);
    }


    /**
     * 失败结果构造器
     * @param message 说明
     * @return 结果
     */
    public static<E> ResponsePack fail(String message) {

        return build(0, message);
    }

    /**
     * 失败结果构造器
     * @param message 说明
     * @param data 数据
     * @return 结果
     */
    public static<E> ResponsePack fail(String message, E data) {

        return build(0, message, data);
    }

    /**
     * 验证结果是否成功
     * @return 是否成功
     */
    public Boolean checkSuccess() {
        return this.code.equals(1);
    }

    /**
     * 验证结果是否挫败
     * @return 是否成功
     */
    public Boolean checkFail() {
        return this.code.equals(0);
    }

}
