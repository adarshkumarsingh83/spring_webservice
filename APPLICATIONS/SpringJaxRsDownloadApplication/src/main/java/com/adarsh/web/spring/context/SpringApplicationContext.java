package com.adarsh.web.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * User: Adarsh_K
 * Date: 23/4/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext appContext;

    public SpringApplicationContext() {}

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        appContext = applicationContext;

    }

    public static Object getBean(String beanName) {
        return appContext.getBean(beanName);
    }

}