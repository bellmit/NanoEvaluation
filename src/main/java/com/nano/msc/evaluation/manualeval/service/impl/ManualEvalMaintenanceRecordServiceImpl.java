package com.nano.msc.evaluation.manualeval.service.impl;


import com.alibaba.fastjson.JSON;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalMaintenanceRecord;
import com.nano.msc.evaluation.manualeval.repository.ManualEvalMaintenanceRecordRepository;
import com.nano.msc.evaluation.manualeval.service.ManualEvalMaintenanceRecordService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManualEvalMaintenanceRecordServiceImpl implements ManualEvalMaintenanceRecordService {

    @Autowired
    private ManualEvalMaintenanceRecordRepository repository;

    /**
     * 解析并返回是否成功
     *
     * @param rawData 原始数据
     * @return 是否成功
     */
    @Override
    public CommonResult parseAndSave(String rawData) {
        // 解析数据
        ManualEvalMaintenanceRecord data = JSON.parseObject(rawData, ManualEvalMaintenanceRecord.class);
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, data);

    }

}
