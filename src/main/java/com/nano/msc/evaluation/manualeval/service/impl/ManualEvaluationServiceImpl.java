package com.nano.msc.evaluation.manualeval.service.impl;

import com.alibaba.fastjson.JSON;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.service.BaseService;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.evaluation.manualeval.component.ManualEvalContext;
import com.nano.msc.evaluation.manualeval.param.ParamManualEval;
import com.nano.msc.evaluation.manualeval.service.ManualEvaluationService;
import com.nano.msc.evaluation.manualeval.service.base.BaseManualService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import javax.annotation.PostConstruct;

import lombok.Getter;


/**
 * 人工评价方式总服务类
 * @author nano
 */
@Service
public class ManualEvaluationServiceImpl implements ManualEvaluationService {

    @Autowired
    private ManualEvalContext manualEvalContext;


    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    private Map<Integer, BaseManualService> manualServiceMap;


    /**
     * 保存人工评价的信息
     *
     * @param paramManualEval 上传的参数
     * @return 是否成功
     */
    @Override
    public CommonResult saveManualEvaluationInfo(ParamManualEval paramManualEval) {

        if (!manualServiceMap.containsKey(paramManualEval.getRequestCode())) {
            return CommonResult.failed(ResultVo.error(ExceptionEnum.CODE_ERROR));
        }
        // 解析并存储数据
        return manualServiceMap.get(paramManualEval.getRequestCode())
                .parseAndSave(paramManualEval.getData());
    }


    /**
     * 容器构造时初始化服务Map
     */
    @PostConstruct
    private void init() {
        this.manualServiceMap = manualEvalContext.getManualServiceMap();
    }

}
