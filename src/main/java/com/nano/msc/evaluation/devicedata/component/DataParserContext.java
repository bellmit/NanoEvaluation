package com.nano.msc.evaluation.devicedata.component;

import com.nano.msc.common.utils.SpringUtil;
import com.nano.msc.evaluation.devicedata.parser.ParserBaoLaiTeA8;
import com.nano.msc.evaluation.devicedata.parser.ParserLiBangEliteV8;
import com.nano.msc.evaluation.devicedata.parser.ParserMaiRuiT8;
import com.nano.msc.evaluation.devicedata.parser.ParserMaiRuiWatoex55Pro;
import com.nano.msc.evaluation.devicedata.parser.ParserMaiRuiWatoex65;
import com.nano.msc.evaluation.devicedata.parser.ParserNuoHe;
import com.nano.msc.evaluation.devicedata.parser.ParserPuKe;
import com.nano.msc.evaluation.devicedata.parser.ParserYiAn8700A;
import com.nano.msc.evaluation.devicedata.parser.base.DeviceDataParser;
import com.nano.msc.evaluation.enums.DeviceCodeEnum;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;


/**
 * 仪器数据解析器上下文
 */
@Component
public class DataParserContext implements InitializingBean, ApplicationContextAware {


    /**
     * 仪器数据解析的Map 键是DeviceCode，值是对应的DataParser
     */
    @Getter
    private Map<Integer, DeviceDataParser> dataParserMap;



    /**
     * 应用上下文
     */
    private ApplicationContext applicationContext;


    /**
     * 构造器
     */
    public DataParserContext() {
        dataParserMap = new HashMap<>();
    }


    /**
     * 容器生成后进行初始化扫描注册
     */
    @Override
    public void afterPropertiesSet() {

        // 容器初始化后进行组件装配
        // 将解析器注入到上下文容器中
        dataParserMap.put(DeviceCodeEnum.NORWAMD_9002S.getCode(), SpringUtil.getBean(ParserNuoHe.class));
        dataParserMap.put(DeviceCodeEnum.PEARLCARE_YY106.getCode(), SpringUtil.getBean(ParserPuKe.class));
        dataParserMap.put(DeviceCodeEnum.BAO_LAI_TE.getCode(), SpringUtil.getBean(ParserBaoLaiTeA8.class));
        dataParserMap.put(DeviceCodeEnum.LI_BANG_ELITE_V8.getCode(), SpringUtil.getBean(ParserLiBangEliteV8.class));
        dataParserMap.put(DeviceCodeEnum.MAI_RUI_T8.getCode(), SpringUtil.getBean(ParserMaiRuiT8.class));
        dataParserMap.put(DeviceCodeEnum.MAI_RUI_WATOEX_55_PRO.getCode(), SpringUtil.getBean(ParserMaiRuiWatoex55Pro.class));
        dataParserMap.put(DeviceCodeEnum.MAI_RUI_WATOEX_65.getCode(), SpringUtil.getBean(ParserMaiRuiWatoex65.class));
        dataParserMap.put(DeviceCodeEnum.YI_AN_8700_A.getCode(), SpringUtil.getBean(ParserYiAn8700A.class));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (this.applicationContext == null) {
            this.applicationContext = applicationContext;
        }
    }
}
