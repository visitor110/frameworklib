package com.pt.javalib.framework.spring;

import com.pt.javalib.JavalibApplicationTests;
import com.pt.javalib.framework.spring.app.UserDao;
import com.pt.javalib.framework.spring.app.UserService;
import com.pt.javalib.framework.spring.config.BeanDefinition;
import com.pt.javalib.framework.spring.config.BeanReference;
import com.pt.javalib.framework.spring.config.BeanValue;
import com.pt.javalib.framework.spring.config.BeanValues;
import com.pt.javalib.framework.spring.factory.DefaultListableBeanFactory;
import com.pt.javalib.framework.spring.factory.XmlBeanDefinitionReader;
import org.junit.jupiter.api.Test;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/23 15:21
 * @description：${description}
 */
public class SpringTest extends JavalibApplicationTests {

    @Test
    public void factoryTest() {


        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));


        BeanValues beanValue = new BeanValues();
        beanValue.addBeanValue(new BeanValue("username","FFFFF"));
        beanValue.addBeanValue(new BeanValue("age",22));
        beanValue.addBeanValue(new BeanValue("userDao",new BeanReference("userDao")));
        factory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, beanValue));

        UserService userService = (UserService) factory.getBean("userService", new Object[]{"AAAA", 22});
        userService.getInfo();
        System.out.println(userService.getUsernameById(1L));
    }

    @Test
    public void AutoRegisterTest() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(factory);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        UserService userService = (UserService) factory.getBean("userService", new Object[]{"AAAA", 22});
        userService.getInfo();
        System.out.println(userService.getUsernameById(1L));
    }
}
