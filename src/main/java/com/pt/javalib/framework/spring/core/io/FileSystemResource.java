package com.pt.javalib.framework.spring.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 10:49
 * @description：${description}
 */
public class FileSystemResource implements Resource {

    private File file;

    private String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(this.file);
        return fileInputStream;
    }
}
