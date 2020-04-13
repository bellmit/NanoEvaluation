package com.nano.msc.evaluation.devicedata.component;

import com.nano.msc.evaluation.devicedata.entity.Norwamd9002s;
import com.nano.msc.evaluation.devicedata.parse.NuoHeParser;
import com.nano.msc.evaluation.devicedata.parse.base.DeviceDataParser;
import com.nano.msc.evaluation.devicedata.repository.Norwamd9002sRepository;
import com.nano.msc.evaluation.enums.DeviceCodeEnum;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Access;

import lombok.Getter;


/**
 * 仪器数据解析器上下文
 */
@Component
public class DataParserContext implements InitializingBean, ApplicationContextAware {


    @Autowired
    private NuoHeParser nuoHeParser;

    @Autowired
    private Norwamd9002sRepository norwamd9002sRepository;

    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    @Getter
    private Map<Integer, DeviceDataParser> dataParserMap;

    @Getter
    private Map<Integer, JpaRepository> repositoryMap;


    /**
     * 应用上下文
     */
    private ApplicationContext applicationContext;


    /**
     * 构造器
     */
    public DataParserContext() {
        dataParserMap = new HashMap<>();
        repositoryMap = new HashMap<>();
    }


    /**
     * 容器生成后进行初始化扫描注册
     */
    @Override
    public void afterPropertiesSet() {
        // 容器初始化后进行组件装配
        dataParserMap.put(DeviceCodeEnum.NORWAMD_9002S.getCode(), nuoHeParser);
        repositoryMap.put(DeviceCodeEnum.NORWAMD_9002S.getCode(), norwamd9002sRepository);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }
}
