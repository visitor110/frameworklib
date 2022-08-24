package com.pt.javalib.framework.spring.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 10:51
 * @description：${description}
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "url不能为空");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection connection = this.url.openConnection();
        try{
            return connection.getInputStream();
        }catch (IOException ex){
            if (connection instanceof HttpURLConnection){
                ((HttpURLConnection) connection).disconnect();
            }
            throw ex;
        }
    }
}
