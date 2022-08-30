package com.pt.javalib.framework.spring.config;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/29 9:45
 * @description：${description}
 */
public interface BeanFactoryPostProcessor {

    void postProcessorBeanFactory(AbstractAutowireCapableBeanFactory beanFactory);


}
