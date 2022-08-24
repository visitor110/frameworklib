package com.pt.javalib.framework.spring.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 10:42
 * @description：${description}
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
