package com.pt.javalib.framework.spring.factory;


/**
 * 声明 BeanPostProcessors 的方法
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName);


    Object applyBeanPostProccessorsAfterInitialization(Object existingBean, String beanName);


}
