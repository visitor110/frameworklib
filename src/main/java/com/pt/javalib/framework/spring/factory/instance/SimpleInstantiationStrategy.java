package com.pt.javalib.framework.spring.factory.instance;

import com.pt.javalib.framework.spring.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 15:49
 * @description：${description}
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws Exception {
        Class beanClass = beanDefinition.getBeanClass();

        try {
            if (constructor == null) {
                return beanClass.getDeclaredConstructor().newInstance();
            } else {
                return beanClass.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
           throw new Exception("构造实例失败[" + beanName + "]");
        }
    }
}
