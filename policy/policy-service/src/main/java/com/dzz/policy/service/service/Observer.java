package com.dzz.policy.service.service;

/**
 * 保单观察者
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月14 16:54
 */
public interface Observer {

    /**
     * 保单观察应用实现
     * @param proposalNo 投保单号
     */
    void apply(String proposalNo);
}