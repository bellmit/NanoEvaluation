package com.nano.msc.evaluation.manualeval.service.impl;


import com.alibaba.fastjson.JSON;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationBrainOxygenMonitor;
import com.nano.msc.evaluation.manualeval.repository.ManualEvalApplicationBrainOxygenMonitorRepository;
import com.nano.msc.evaluation.manualeval.service.ManualEvalApplicationBrainOxygenMonitorService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManualEvalApplicationBrainOxygenMonitorServiceImpl implements ManualEvalApplicationBrainOxygenMonitorService {

    @Autowired
    private ManualEvalApplicationBrainOxygenMonitorRepository repository;

    /**
     * 解析并返回是否成功
     *
     * @param rawData 原始数据
     * @return 是否成功
     */
    @Override
    public CommonResult parseAndSave(String rawData) {
        // 解析数据
        ManualEvalApplicationBrainOxygenMonitor data = JSON.parseObject(rawData, ManualEvalApplicationBrainOxygenMonitor.class);
        // 检查并保存数据
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, data);
    }

}
