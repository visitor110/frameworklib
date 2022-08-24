package com.pt.javalib.framework.spring.app;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 15:20
 * @description：${description}
 */
public class UserService {

    private String username;

    private Integer age;

    private UserDao userDao;

    public UserService() {
    }

    public UserService(String username) {
        this.username = username;
    }

    public UserService(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public void getInfo(){
        System.out.println(this.username + this.age);
    }

    public String getUsernameById(Long id){
        return userDao.getNameById(id);
    }

}
