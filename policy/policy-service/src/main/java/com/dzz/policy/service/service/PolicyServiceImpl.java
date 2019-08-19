package com.dzz.policy.service.service;

import com.alibaba.fastjson.JSON;
import com.dzz.policy.api.domain.bo.PolicyDetailBo;
import com.dzz.policy.api.domain.bo.PolicyListBo;
import com.dzz.policy.api.domain.dto.PolicyListParam;
import com.dzz.policy.api.domain.dto.PolicySaveParam;
import com.dzz.policy.api.service.PolicyService;
import com.dzz.policy.service.config.exception.BusinessException;
import com.dzz.policy.service.domain.dao.PolicyMapper;
import com.dzz.policy.service.domain.model.Policy;
import com.dzz.util.page.PageUtil;
import com.dzz.util.response.ResponsePack;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DemoService 实现
 *
 * @author dzz
 * @version 1.0.0
 * @since 2019年08月09 22:10
 */
@Service
@Slf4j
public class PolicyServiceImpl implements PolicyService {

    private PolicyMapper policyMapper;

    @Autowired
    private BeanToolsService beanToolsService;

    @Autowired
    private SendToBusinessObserverImpl sendToBusinessObserver;

    @Autowired
    private SendToCentralObserverImpl sendToCentralObserver;

    @Autowired
    public void setPolicyMapper(PolicyMapper policyMapper) {
        this.policyMapper = policyMapper;
    }

    @Override
    public ResponsePack<Boolean> savePolicy(PolicySaveParam saveParam) {

        Policy policy = beanToolsService.convertToPolicy(saveParam);
        return ResponsePack.ok(policyMapper.insert(policy)>0);
    }

    @Override
    public ResponsePack<PageUtil<PolicyListBo>> listPolicy(PolicyListParam listParam) {

        PageHelper.startPage(listParam.getPageNo(), listParam.getPageSize(), true);
        PageUtil<PolicyListBo> pageUtil = new PageUtil<>();
        List<PolicyListBo> listPolicy = policyMapper.listPolicy(listParam);
        PageInfo<PolicyListBo> pageInfo = new PageInfo<>(listPolicy);
        pageUtil.setPageNo(pageInfo.getPageNum());
        pageUtil.setPageSize(pageInfo.getPageSize());
        pageUtil.setData(pageInfo.getList());
        pageUtil.setTotalCount(pageInfo.getTotal());
        pageUtil.setTotalPage(pageInfo.getPages());
        return ResponsePack.ok(pageUtil);
    }

    @Override
    public ResponsePack<PolicyDetailBo> detailPolicy(String policyNo) {

        return ResponsePack.ok(policyMapper.detailPolicy(policyNo));
    }

    /**
     * 调承保接口
     * @param proposalNo proposalNo
     * @return 结果
     */
    @Override
    public ResponsePack<String> applyInsuranceService(String proposalNo) {

        long startTime = System.currentTimeMillis();
        ResponsePack<String> responsePack = sendInsurance(proposalNo);
        log.info("发送承保耗时:{}秒，返回结果为:{}", (System.currentTimeMillis() - startTime) / 1000, JSON.toJSONString(
                responsePack));
        if(responsePack.checkFail() || null == responsePack.getData()) {
            log.error("发送承保公司异常,{}", responsePack.getMessage());
            throw new BusinessException("发送承保公司异常");
        }
        Observable observable = new Observable();
        observable.addObserver(sendToBusinessObserver);
        observable.addObserver(sendToCentralObserver);
        observable.notifyObservers(proposalNo);
        log.info("返回处理结果为:{}", JSON.toJSONString(responsePack));
        return responsePack;
    }

    /**
     * 发送保险公司
     * @param proposalNo proposalNo
     * @return 结果
     */
    public ResponsePack<String> sendInsurance(String proposalNo) {

        return ResponsePack.ok("aaaaaaaaaa");
    }
}
