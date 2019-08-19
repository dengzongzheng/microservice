package com.dzz.policy.service.service.insurance;

import com.dzz.util.response.ResponsePack;

/**
 * 发送保险公司抽象类
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 13:54
 */
public interface SendInsuranceService {

    /**
     * 获取产品code
     * @return product_code
     */
    String getProductCode();

    /**
     * 调用核保
     * @param proposalNo 投保单号
     * @return 核保结果
     */
    ResponsePack applyPrepareUnderwriting(String proposalNo);


    /**
     * 调用承保
     * @param proposalNo 投保单号
     */
    void applyUnderwriting(String proposalNo);


    /**
     * 退保
     * @param proposalNo 投保单号
     * @return 退保结果
     */
    ResponsePack refundUnderwriting(String proposalNo);
}
