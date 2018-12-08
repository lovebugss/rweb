package com.itrjp.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Created by ren on 2018/11/3.
 */
@Component
@Lazy(false)
public class SpringUtil {

    public static final Logger logger = LoggerFactory.getLogger(SpringUtil.class);
    private static ApplicationContext applicationContext ;

    public static void setApplicationContext(ApplicationContext applicationContext){
        if(SpringUtil.applicationContext == null){
            logger.info("set applicationcontext");
            SpringUtil.applicationContext  = applicationContext;
        }

    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);

    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        if(SpringUtil.applicationContext == null){
//            logger.info("set applicationcontext");
//            SpringUtil.applicationContext  = applicationContext;
//        }
//    }
}
