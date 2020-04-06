package org.killer.springmercydemo.unit.bean_lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author killer
 * @date 2020/03/29 - 21:58
 */
public class BeanLifeCycleDemo {

    public static void main(String[] args) {

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("META-INF/spring-config.xml"));

        defaultListableBeanFactory.getBean("user");

    }

}
