package com.pt.javalib.framework.spring.app;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 17:35
 * @description：${description}
 */
public class UserDao {

    private static Map<Long, String> map = new HashMap<>();

    static{
        map.put(1L,"AAA");
        map.put(2L,"BBB");
    }

    public String getNameById(Long userId){
        return this.map.getOrDefault(userId,"查无此人");
    }
}
