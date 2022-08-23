package com.pt.javalib.framework.spring.config;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 17:24
 * @description：${description}
 */
public class BeanReference {
    private String beanName;

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
