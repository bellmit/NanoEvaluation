package com.nano.msc.evaluation.manualeval.service.impl;


import com.alibaba.fastjson.JSON;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationNormalMonitor;
import com.nano.msc.evaluation.manualeval.repository.ManualEvalApplicationNormalMonitorRepository;
import com.nano.msc.evaluation.manualeval.service.ManualEvalApplicationNormalMonitorService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManualEvalApplicationNormalMonitorServiceImpl implements ManualEvalApplicationNormalMonitorService {

    @Autowired
    private ManualEvalApplicationNormalMonitorRepository repository;

    /**
     * 解析并返回是否成功
     *
     * @param rawData 原始数据
     * @return 是否成功
     */
    @Override
    public CommonResult parseAndSave(String rawData) {
        // 解析数据
        ManualEvalApplicationNormalMonitor data = JSON.parseObject(rawData, ManualEvalApplicationNormalMonitor.class);
        // 检查并保存数据
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, data);
    }

}
