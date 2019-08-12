package com.dzz.util.validate;

import com.dzz.util.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

/**
 * 校验结果处理
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月12 18:21
 */
@Slf4j
public class ValidateResultHandler {

    /**
     * 校验结果处理
     * @param bindingResult 校验结果
     */
    public static void bindResultHandler(BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.info("校验失败，错误信息:{}",bindingResult.getAllErrors());
            throw new BusinessException(bindingResult.getFieldErrors().get(0).getDefaultMessage());
        }
    }
}
