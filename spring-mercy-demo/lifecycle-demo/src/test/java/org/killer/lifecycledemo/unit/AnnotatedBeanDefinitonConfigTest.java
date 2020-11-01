package org.killer.lifecycledemo.unit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author killer
 * @date 2020/06/09 - 23:11
 */
class AnnotatedBeanDefinitonConfigTest {

    @Test
    void test() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);

        System.out.println(beanFactory.getBeanDefinitionCount());
        System.out.println(Arrays.toString(beanFactory.getBeanDefinitionNames()));
        annotatedBeanDefinitionReader.register(AnnotatedBeanDefinitonConfigTest.class);
        // 我的疑惑就是，为什么没有扫描类路径的接口
        System.out.println(beanFactory.getBeanDefinitionCount());

        // 以上代码就是类似于AnnotationConfigApplicationContext配置吧，，
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.refresh();


    }

}
