package com.pt.javalib.framework.spring.config;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 17:22
 * @description：${description}
 */
public class BeanValues {

    private List<BeanValue> beanValueList = new ArrayList<>();

    public List<BeanValue> getBeanValueList(){return this.beanValueList;}

    public void addBeanValue(BeanValue value){
        this.beanValueList.add(value);
    }

    public BeanValue getBeanValue(String name){
        for (BeanValue beanValue : this.beanValueList) {
            if (beanValue.getName().equals(name)){
                return beanValue;
            }
        }
        return null;
    }
}
