package com.pt.javalib.framework.spring.factory.instance;

import com.pt.javalib.framework.spring.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 15:48
 * @description：${description}
 */
public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws Exception;
}
