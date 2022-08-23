package com.pt.javalib.framework.spring.factory;

import com.pt.javalib.framework.spring.config.BeanDefinition;
import com.pt.javalib.framework.spring.config.BeanDefinitionRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:58
 * @description：${description}
 */
public class DefaultListableBeanFactory extends AbstarctAutowireCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> definitionMap = new ConcurrentHashMap<>();

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return this.definitionMap.containsKey(beanName) ? this.definitionMap.get(beanName) : null;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.definitionMap.put(beanName, beanDefinition);
    }
}
