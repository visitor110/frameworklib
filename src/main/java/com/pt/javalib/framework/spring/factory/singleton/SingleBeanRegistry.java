package com.pt.javalib.framework.spring.factory.singleton;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:40
 * @description：${description}
 */
public interface SingleBeanRegistry {

    Object getSingletonBean(String beanName);
}
