package com.pt.javalib.framework.spring.factory;

import java.util.Map;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/29 9:52
 * @description：${description}
 */
public interface ListableBeanFactory extends BeanFactory {

    <T> Map<String, T> getBeansOfType(Class<T> type);

    String[] getBeanDefinitionNames();
}
