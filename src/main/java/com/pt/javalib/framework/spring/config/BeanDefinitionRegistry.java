package com.pt.javalib.framework.spring.config;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 15:06
 * @description：${description}
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);

}
