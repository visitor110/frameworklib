package com.pt.javalib.framework.spring.factory;

import com.pt.javalib.framework.spring.config.BeanDefinition;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory,
        AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeaDefinition(String beanName);
}
