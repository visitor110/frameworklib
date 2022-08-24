package com.pt.javalib.framework.spring.factory;

import com.pt.javalib.framework.spring.config.BeanDefinitionRegistry;
import com.pt.javalib.framework.spring.core.io.DefaultResourceLoader;
import com.pt.javalib.framework.spring.core.io.ResourceLoader;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 11:05
 * @description：${description}
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    private ResourceLoader resourceLoader;

    private BeanDefinitionRegistry beanDefinitionRegistry;


    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(new DefaultResourceLoader(), registry);
    }

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry beanDefinitionRegistry) {
        this.resourceLoader = resourceLoader;
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }


}
