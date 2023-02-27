package com.pt.javalib.framework.spring.factory.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 14:41
 * @description：${description}
 */
public class DefaultSingletonBeanRegistry implements SingleBeanRegistry {

    private Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonMap.containsKey(beanName) ? singletonMap.get(beanName) : null;
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        this.singletonMap.put(beanName, singletonObject);
    }
}
