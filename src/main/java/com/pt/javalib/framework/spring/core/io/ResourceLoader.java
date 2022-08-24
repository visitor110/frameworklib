package com.pt.javalib.framework.spring.core.io;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 10:57
 * @description：${description}
 */
public interface ResourceLoader {

    String CLASSPATH_URL_PREFIX =   "classpath:";

    Resource getResource(String location);
}
