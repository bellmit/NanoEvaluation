package com.nano.msc.evaluation.manualeval.service;


import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.evaluation.manualeval.param.ParamManualEval;

/**
 * 人工问卷评价方式的总服务类
 * @author nano
 */
public interface ManualEvaluationService {

    CommonResult saveManualEvaluationInfo(ParamManualEval paramManualEval);

}
