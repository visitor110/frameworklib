package com.pt.javalib.framework.spring.factory;

import com.pt.javalib.framework.spring.config.BeanPostProcessor;
import com.pt.javalib.framework.spring.factory.singleton.SingleBeanRegistry;

public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingleBeanRegistry {

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

//    void destroySingletons();
}
