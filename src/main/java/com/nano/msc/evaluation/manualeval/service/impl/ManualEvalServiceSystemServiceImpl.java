package com.nano.msc.evaluation.manualeval.service.impl;


import com.alibaba.fastjson.JSON;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalServiceSystem;
import com.nano.msc.evaluation.manualeval.repository.ManualEvalServiceSystemRepository;
import com.nano.msc.evaluation.manualeval.service.ManualEvalServiceSystemService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManualEvalServiceSystemServiceImpl implements ManualEvalServiceSystemService {

    @Autowired
    private ManualEvalServiceSystemRepository repository;

    /**
     * 解析并返回是否成功
     *
     * @param rawData 原始数据
     * @return 是否成功
     */
    @Override
    public CommonResult parseAndSave(String rawData) {
        // 解析数据
        ManualEvalServiceSystem data = JSON.parseObject(rawData, ManualEvalServiceSystem.class);
        // 检查并保存数据
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, data);

    }
}
