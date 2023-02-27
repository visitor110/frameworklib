package com.pt.javalib.framework.spring.factory;

import cn.hutool.core.bean.BeanUtil;
import com.pt.javalib.framework.spring.config.BeanDefinition;
import com.pt.javalib.framework.spring.config.BeanReference;
import com.pt.javalib.framework.spring.config.BeanValue;
import com.pt.javalib.framework.spring.config.BeanValues;
import com.pt.javalib.framework.spring.factory.instance.InstantiationStrategy;
import com.pt.javalib.framework.spring.factory.instance.SimpleInstantiationStrategy;

import java.lang.reflect.Constructor;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:56
 * @description：${description}
 */
public abstract class AbstarctAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName, beanDefinition, args);
            applyBeanValue(bean, beanDefinition);
            registerSingleton(beanName, beanDefinition);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    private Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws Exception {

        Constructor[] constructors = beanDefinition.getBeanClass().getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            if (args != null && constructor.getParameterTypes().length == args.length) {
                return instantiationStrategy.instantiate(beanName, beanDefinition, constructor, args);
            }
        }
        return instantiationStrategy.instantiate(beanName, beanDefinition, null, null);
    }

    private void applyBeanValue(Object bean, BeanDefinition beanDefinition) {
        BeanValues beanValues = beanDefinition.getBeanValues();
        for (BeanValue beanValue : beanValues.getBeanValueList()) {
            String name = beanValue.getName();
            Object value = beanValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference reference = (BeanReference) value;
                value = getBean(reference.getBeanName());
            }
            BeanUtil.setFieldValue(bean, name, value);
        }
    }
}
