package com.nano.msc.info;

import com.alibaba.fastjson.JSON;
import com.nano.msc.evaluation.manualeval.entity.ManualEvalServiceSystem;
import com.nano.msc.evaluation.manualeval.enums.ManualEvalTypeEnum;
import com.nano.msc.evaluation.manualeval.param.ParamManualEval;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManualEvalPostTest {


    @Test
    public void postManualEval() {

        ManualEvalServiceSystem serviceSystem = new ManualEvalServiceSystem();
        serviceSystem.setDoctorName("Test");
        serviceSystem.setAfterSaleServiceComplaintHandingSatisfaction("123");
        serviceSystem.setAfterSaleServiceFaultExcludeTime("2018.06");
        serviceSystem.setAfterSaleServiceProducerAttitude("测试");
        serviceSystem.setAverageMaintainTimeWhenDeviceFault("Eval");
        serviceSystem.setCompanyName("诺和");
        serviceSystem.setDeviceCategory("麻醉机");
        serviceSystem.setDoctorDepartment("麻醉科");

        ParamManualEval paramManualEval = new ParamManualEval();
        paramManualEval.setRequestCode(ManualEvalTypeEnum.SERVICE_SYSTEM.getCode());
        paramManualEval.setData(JSON.toJSONString(serviceSystem));
        System.out.println(JSON.toJSONString(paramManualEval));

    }

}
