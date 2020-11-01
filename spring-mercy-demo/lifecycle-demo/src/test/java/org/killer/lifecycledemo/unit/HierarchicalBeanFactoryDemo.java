package org.killer.lifecycledemo.unit;

import org.killer.lifecycledemo.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author killer
 * @date 2020/11/01 - 21:10
 */
public class HierarchicalBeanFactoryDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory parent = new DefaultListableBeanFactory();
        DefaultListableBeanFactory child = new DefaultListableBeanFactory();

        child.setParentBeanFactory(parent);

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1);

        parent.registerBeanDefinition("user", builder.getBeanDefinition());

        System.out.println(child.containsLocalBean("user"));

        System.out.println(child.getBean("user"));
    }

}
