package com.pt.javalib.framework.spring.config;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/29 9:47
 * @description：${description}
 */
public interface BeanPostProcessor {

    Object postProcessBeforeInitialization(Object bean, String beanName);

    Object postProcessAfterInitialization(Object bean, String beanName);
}
