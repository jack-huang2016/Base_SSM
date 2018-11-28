package com.yougou.bi.mdp.service.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContexts implements ApplicationContextAware {
	 private static ApplicationContext context;

	    @Override
	    public void setApplicationContext(ApplicationContext contex) throws BeansException {
	        SpringContexts.context = contex;
	    }

	    public static ApplicationContext getContext() {
	        return context;
	    }

	    /**
	     * 获取spring 管理的bean
	     * @param name
	     * @param requiredType
	     * @return
	     */
	    public static <T> T getBean(String name, Class<T> requiredType) {
	        return context.getBean(name, requiredType);
	    }

}
