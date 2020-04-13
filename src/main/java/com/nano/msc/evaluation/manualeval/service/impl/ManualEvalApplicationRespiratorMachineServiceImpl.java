package com.nano.msc.evaluation.manualeval.service.impl;


import com.alibaba.fastjson.JSON;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationRespiratorMachine;
import com.nano.msc.evaluation.manualeval.repository.ManualEvalApplicationRespiratorMachineRepository;
import com.nano.msc.evaluation.manualeval.service.ManualEvalApplicationRespiratorMachineService;
import com.nano.msc.evaluation.utils.ServiceCrudCheckUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ManualEvalApplicationRespiratorMachineServiceImpl implements ManualEvalApplicationRespiratorMachineService {

    @Autowired
    private ManualEvalApplicationRespiratorMachineRepository repository;

    /**
     * 解析并返回是否成功
     *
     * @param rawData 原始数据
     * @return 是否成功
     */
    @Override
    public CommonResult parseAndSave(String rawData) {
        // 解析数据
        ManualEvalApplicationRespiratorMachine data = JSON.parseObject(rawData, ManualEvalApplicationRespiratorMachine.class);
        return ServiceCrudCheckUtils.saveObjectAndCheck(repository, data);

    }

}
