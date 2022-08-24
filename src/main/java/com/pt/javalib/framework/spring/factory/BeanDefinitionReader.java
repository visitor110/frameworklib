package com.pt.javalib.framework.spring.factory;

import com.pt.javalib.framework.spring.config.BeanDefinitionRegistry;
import com.pt.javalib.framework.spring.core.io.Resource;
import com.pt.javalib.framework.spring.core.io.ResourceLoader;

import java.util.List;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 11:03
 * @description：${description}
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(List<Resource> resources);

    void loadBeanDefinitions(String location);
}
