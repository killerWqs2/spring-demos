package org.killer.lifecycledemo.unit;

import org.killer.lifecycledemo.entity.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author killer
 * @date 2020/06/09 - 22:29
 */
public class PropertiesConfigApplicationContextTest {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // beanFactory 继承了BeanDefinitionRegistry接口
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);

        int i = propertiesBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("META-INF/spring-context.properties"));

        User bean = beanFactory.getBean(User.class);

        System.out.println(bean.getName());

        System.out.println(beanFactory.getBeanDefinitionCount());

        System.out.println(i);
    }

}
