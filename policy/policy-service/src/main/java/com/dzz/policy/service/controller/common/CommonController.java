package com.dzz.policy.service.controller.common;

import com.dzz.policy.api.domain.bo.IntervalDateBo;
import com.dzz.policy.api.service.CommonService;
import com.dzz.util.response.ResponsePack;
import io.swagger.annotations.Api;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 公共方法实现Controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月19 17:37
 */
@RestController
@Api(value = "公共接口API", tags = "公共接口API")
@Slf4j
@SuppressWarnings("ALL")
public class CommonController {



    /**
     * 获取多少天后的日期
     *
     * @param day 几天可取值:0-365
     * @return 结果数据yyyy-MM-dd
     */
    @GetMapping(CommonService.GET_DATE_AFTER_DAY)
    public ResponsePack<String> getDateAfterDay(Integer day) {
        if(day > 365 || day < 0) {
            log.error("参数错误，参数只能接收0-365之间，实际参数为:{}", day);
            return ResponsePack.fail("参数错误");
        }
        return ResponsePack.ok(LocalDate.now().plusDays(day).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }


    /**
     * 当前时间是否可投保
     *
     * @return 是否可投保true or false
     */
    @GetMapping(CommonService.CAN_PROPOSAL_NOW)
    public ResponsePack<Boolean> canProposalNow() {

        LocalTime localTime = LocalTime.now();
        return ResponsePack.ok(localTime.isBefore(LocalTime.of(23, 45)));
    }


    /**
     * 获取当前时间minDay天后到maxDay后的的日期
     *
     * @param minDay 间隔最少时间
     * @param maxDay 间隔最大时间
     * @return 结果数据日期格式为yyyy-MM-dd
     */
    @GetMapping(CommonService.GET_INTERVAL_DATE)
    public ResponsePack<IntervalDateBo> getIntervalDate(Integer minDay, Integer maxDay) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.now();
        IntervalDateBo intervalDateBo = IntervalDateBo.builder()
                .startDate(localDate.plusDays(minDay).format(dateTimeFormatter))
                .endDate(localDate.plusDays(maxDay).format(dateTimeFormatter)).build();
        return ResponsePack.ok(intervalDateBo);
    }

}
