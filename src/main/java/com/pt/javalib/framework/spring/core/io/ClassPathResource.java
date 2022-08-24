package com.pt.javalib.framework.spring.core.io;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ClassUtil;
import org.springframework.util.ClassUtils;

import java.io.InputStream;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 10:43
 * @description：${description}
 */
public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path,"path 不能为空");
        this.path = path;
        this.classLoader = classLoader == null ? ClassUtils.getDefaultClassLoader() : classLoader;
    }

    @Override
    public InputStream getInputStream() {
        InputStream is = this.classLoader.getResourceAsStream(this.path);
        Assert.notNull(is,this.path + "不存在");
        return is;
    }
}
