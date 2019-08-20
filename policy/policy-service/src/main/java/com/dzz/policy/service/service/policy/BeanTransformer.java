package com.dzz.policy.service.service.policy;

/**
 * 转换接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月20 10:29
 */
@FunctionalInterface
public interface BeanTransformer<T,R> {

    /**
     * 转换
     * @param input 输入
     * @return 输出
     */
    R transform(T input);
}