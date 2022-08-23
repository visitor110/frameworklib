package com.pt.javalib.framework.spring.config;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 17:22
 * @description：${description}
 */
public class BeanValue {

    private String name;
    private Object value;

    public BeanValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
