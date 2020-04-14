package com.nano.msc.evaluation.manualeval.controller;

import com.alibaba.fastjson.JSONObject;
import com.nano.msc.common.enums.ExceptionEnum;
import com.nano.msc.common.vo.CommonResult;
import com.nano.msc.common.vo.ResultVo;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationAnesthesiaDepthMonitor;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationAnesthesiaMachine;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationBrainOxygenMonitor;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationHemoglobinMonitor;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationNormalMonitor;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalApplicationRespiratorMachine;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalMaintenanceRecord;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalServiceSystem;
import com.nano.msc.evaluation.manualeval.enums.ManualEvalTypeEnum;
import com.nano.msc.evaluation.manualeval.param.ParamManualEval;
import com.nano.msc.evaluation.manualeval.service.ManualEvaluationService;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationAnesthesiaDepthMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationAnesthesiaMachineServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationBrainOxygenMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationHemoglobinMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationNormalMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationRespiratorMachineServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalMaintenanceRecordServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalServiceSystemServiceImpl;
import com.nano.msc.system.log.service.SystemLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

/**
 * 人工问卷评价Controller
 * @author nano
 */
@RestController
@Slf4j
@Api(value = "ManualEvaluationController", description = "人工仪器评价控制器")
@RequestMapping("/manual")
public class ManualEvaluationController {

    @Autowired
    private ManualEvaluationService manualEvaluationService;

    @PostMapping("/post_record")
    public CommonResult postManualEvaluationRecords(@Valid @RequestBody ParamManualEval paramManualEval) {
        return manualEvaluationService.saveManualEvaluationInfo(paramManualEval);
    }

}
