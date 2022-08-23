package com.pt.javalib.framework.spring.factory;

import com.pt.javalib.framework.spring.config.BeanDefinition;
import com.pt.javalib.framework.spring.factory.singleton.DefaultSingletonBeanRegistry;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:37
 * @description：${description}
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) {
     return getBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object[] args) {

        Object bean = getSingletonBean(beanName);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(beanName);
        return createBean(beanName, beanDefinition, args);

    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
}
