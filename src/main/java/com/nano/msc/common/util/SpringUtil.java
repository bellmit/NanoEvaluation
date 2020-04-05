package com.nano.msc.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 获取Spring Bean的封装类
 * @author jerval
 */
public class SpringUtil {
    private static ApplicationContext context;
    static {
        try {
            context = new ClassPathXmlApplicationContext(
                    "applicationContext.xml");
            System.out.println(context);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
