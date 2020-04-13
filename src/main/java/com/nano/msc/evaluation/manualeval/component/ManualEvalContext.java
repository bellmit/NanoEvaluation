package com.nano.msc.evaluation.manualeval.component;

import com.nano.msc.common.service.BaseService;
import com.nano.msc.common.utils.SpringUtil;
import com.nano.msc.evaluation.manualeval.enums.ManualEvalTypeEnum;
import com.nano.msc.evaluation.manualeval.service.ManualEvalApplicationAnesthesiaDepthMonitorService;
import com.nano.msc.evaluation.manualeval.service.base.BaseManualService;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationAnesthesiaDepthMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationAnesthesiaMachineServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationBrainOxygenMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationHemoglobinMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationNormalMonitorServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalApplicationRespiratorMachineServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalMaintenanceRecordServiceImpl;
import com.nano.msc.evaluation.manualeval.service.impl.ManualEvalServiceSystemServiceImpl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

/**
 * 人工问卷评价的上下文环境
 * @author nano
 */
@Component
public class ManualEvalContext implements InitializingBean, ApplicationContextAware {

    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    @Getter
    private Map<Integer, BaseManualService> manualServiceMap;

    @Getter
    private Map<Integer, Class<?>> manualEvalClassMap;


    /**
     * 应用上下文
     */
    private ApplicationContext applicationContext;


    /**
     * 构造器
     */
    public ManualEvalContext() {
        manualServiceMap = new HashMap<>();
        manualEvalClassMap = new HashMap<>();
    }


    /**
     * 容器生成后进行初始化扫描注册
     */
    @Override
    public void afterPropertiesSet() {

        // 容器初始化后进行组件装配
        // 将解析器注入到上下文容器中
        manualServiceMap.put(ManualEvalTypeEnum.APPLICATION_ANESTHESIA_DEPTH_MONITOR.getCode(), SpringUtil.getBean(ManualEvalApplicationAnesthesiaDepthMonitorServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.APPLICATION_ANESTHESIA_MACHINE.getCode(), SpringUtil.getBean(ManualEvalApplicationAnesthesiaMachineServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.APPLICATION_BRAIN_OXYGEN_MONITOR.getCode(), SpringUtil.getBean(ManualEvalApplicationBrainOxygenMonitorServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.APPLICATION_HEMOGLOBIN_MONITOR.getCode(), SpringUtil.getBean(ManualEvalApplicationHemoglobinMonitorServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.APPLICATION_NORMAL_MONITOR.getCode(), SpringUtil.getBean(ManualEvalApplicationNormalMonitorServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.APPLICATION_RESPIRATOR_MACHINE.getCode(), SpringUtil.getBean(ManualEvalApplicationRespiratorMachineServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.SERVICE_SYSTEM.getCode(), SpringUtil.getBean(ManualEvalServiceSystemServiceImpl.class));
        manualServiceMap.put(ManualEvalTypeEnum.MAINTENANCE_RECORD.getCode(), SpringUtil.getBean(ManualEvalMaintenanceRecordServiceImpl.class));

        manualEvalClassMap.put(ManualEvalTypeEnum.APPLICATION_ANESTHESIA_DEPTH_MONITOR.getCode(), ManualEvalApplicationAnesthesiaDepthMonitorServiceImpl.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }


}
