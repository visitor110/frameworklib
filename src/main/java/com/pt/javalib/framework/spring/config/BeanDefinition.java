package com.pt.javalib.framework.spring.config;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:37
 * @description：${description}
 */
public class BeanDefinition {

    private Class beanClass;

    private BeanValues beanValues;

    public BeanDefinition(Class beanClass) {
        this(beanClass,null);
    }

    public BeanDefinition(Class beanClass, BeanValues beanValues) {
        this.beanClass = beanClass;
        this.beanValues = beanValues == null ? new BeanValues() : beanValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public BeanValues getBeanValues() {
        return beanValues;
    }

    public void setBeanValues(BeanValues beanValues) {
        this.beanValues = beanValues;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
