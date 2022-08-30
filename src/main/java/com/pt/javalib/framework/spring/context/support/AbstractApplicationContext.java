package com.pt.javalib.framework.spring.context.support;

import com.pt.javalib.framework.spring.context.ConfigurableApplicationContext;
import com.pt.javalib.framework.spring.core.io.DefaultResourceLoader;
import com.pt.javalib.framework.spring.factory.BeanFactory;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/29 9:57
 * @description：${description}
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {


    @Override
    public void refresh() {


        refreshBeanFactory();

        getBeanFactory();




    }

    protected abstract void refreshBeanFactory();

    protected abstract BeanFactory getBeanFactory();



}
