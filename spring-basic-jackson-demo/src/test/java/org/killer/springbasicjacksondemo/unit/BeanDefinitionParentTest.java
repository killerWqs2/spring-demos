package org.killer.springbasicjacksondemo.unit;

import org.junit.jupiter.api.Test;
import org.junit.platform.engine.discovery.ClasspathResourceSelector;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.net.URL;

/**
 * @author killer
 * @date 2020/06/14 - 22:33
 */
class BeanDefinitionParentTest {

    public static void main(String[] args) {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions("F:\\2020-3\\spring-demos\\spring-basic-jackson-demo\\target\\classes\\META-INF\\spring-config.xml");

        System.out.println(beanFactory.getBeanDefinitionCount());

        // classpath resources 是从classpath路径下加载资源，但是资源存在的，为什么没有记载到classloader里面呢？？

    }

    @Test
    void test() {

        ClassPathResource classPathResource = new ClassPathResource("classpath: META-INF\\spring-config.xml");

        System.out.println(classPathResource.exists());

        ClassPathResource classPathResource1 = new ClassPathResource("classpath:application.properties");

        System.out.println(classPathResource1.exists());

        // 我猜可能是多模块的原因吧，，

    }

}
