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
    public Object getSingletonBean(String beanName) {
        return singletonMap.containsKey(beanName) ? singletonMap.get(beanName) : null;
    }

    protected void addSingleton(String beanName, Object bean){
        this.singletonMap.put(beanName, bean);
    }
}
