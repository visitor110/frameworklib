package com.pt.javalib.framework.spring.factory;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:14
 * @description：${description}
 */
public interface BeanFactory {

    Object getBean(String beanName);

    Object getBean(String beanName, Object[] args);
}
