package com.pt.javalib.framework.spring.factory;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.pt.javalib.framework.spring.config.BeanDefinition;
import com.pt.javalib.framework.spring.config.BeanDefinitionRegistry;
import com.pt.javalib.framework.spring.config.BeanReference;
import com.pt.javalib.framework.spring.config.BeanValue;
import com.pt.javalib.framework.spring.core.io.Resource;
import com.pt.javalib.framework.spring.core.io.ResourceLoader;
import org.apache.logging.log4j.util.Strings;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ：peitong
 * @date ：Created in 2022/8/24 11:09
 * @description：${description}
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(ResourceLoader resourceLoader, BeanDefinitionRegistry beanDefinitionRegistry) {
        super(resourceLoader, beanDefinitionRegistry);
    }


    @Override
    public void loadBeanDefinitions(Resource resource) {
        try (InputStream inputStream = resource.getInputStream();) {
            doLoadBeanDefinitions(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void loadBeanDefinitions(List<Resource> resources) {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    private void doLoadBeanDefinitions(InputStream inputStream) throws Exception {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();
        for (int i = 0, len = childNodes.getLength(); i < len; i++) {
            if (!(childNodes.item(i) instanceof Element)) continue;
            if (!childNodes.item(i).getNodeName().equals("bean")) continue;
            Element element = (Element) childNodes.item(i);
            String id = element.getAttribute("id");
            String name = element.getAttribute("name");
            String className = element.getAttribute("class");
            Class<?> bean = Class.forName(className);
            String beanName = Strings.isNotEmpty(id) ? id :
                    (Strings.isNotEmpty(name) ? name : StrUtil.lowerFirst(bean.getSimpleName()));

            BeanDefinition beanDefinition = new BeanDefinition(bean);
            for (int j = 0, len2 = element.getChildNodes().getLength(); j < len2; j++) {
                if (!(element.getChildNodes().item(j) instanceof Element)) continue;
                if (!element.getChildNodes().item(j).getNodeName().equals("property")) continue;
                Element property = (Element) element.getChildNodes().item(j);
                String nameProperty = property.getAttribute("name");
                String valueProperty = property.getAttribute("value");
                String refProperty = property.getAttribute("ref");

                Object value = Strings.isEmpty(refProperty) ? valueProperty : new BeanReference(refProperty);
                BeanValue beanValue = new BeanValue(nameProperty, value);
                beanDefinition.getBeanValues().addBeanValue(beanValue);
            }
            BeanDefinitionRegistry registry = getRegistry();
            if (registry.containsBeanDefinition(beanName)) {
                throw new Exception("beanDefinitionMap中有相同的bean" + beanName);
            }
            registry.registerBeanDefinition(beanName, beanDefinition);
        }
    }
}
