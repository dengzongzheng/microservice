package com.dzz.policy.api.service;

import com.dzz.policy.api.config.PolicyServiceFeignConfiguration;
import com.dzz.policy.api.domain.bo.IntervalDateBo;
import com.dzz.util.response.ResponsePack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 公共接口
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 17:14
 */
@FeignClient(name = "policy-service", configuration = PolicyServiceFeignConfiguration.class)
public interface CommonService {


    String BASE_URL = "/api/common/";


    String GET_DATE_AFTER_DAY = BASE_URL + "getDateAfterDay";


    String CAN_PROPOSAL_NOW = BASE_URL + "canProposalNow";


    String GET_INTERVAL_DATE = BASE_URL + "getIntervalDate";

    /**
     * 获取多少天后的日期
     * @param day 几天可取值:0-365
     * @return 结果数据yyyy-MM-dd
     */
    @GetMapping(GET_DATE_AFTER_DAY)
    ResponsePack<String> getDateAfterDay(@RequestParam("day") Integer day);


    /**
     * 获取当前时间minDay天后到maxDay后的的日期
     * @param minDay 间隔最少时间
     * @param maxDay 间隔最大时间
     * @return 结果数据日期格式为yyyy-MM-dd
     */
    @GetMapping(GET_INTERVAL_DATE)
    ResponsePack<IntervalDateBo> getIntervalDate(@RequestParam("minDay") Integer minDay,
            @RequestParam("maxDay")  Integer maxDay);


    /**
     * 当前时间是否可投保
     * @return 是否可投保true or false
     */
    @GetMapping(CAN_PROPOSAL_NOW)
    ResponsePack<Boolean> canProposalNow();
}
