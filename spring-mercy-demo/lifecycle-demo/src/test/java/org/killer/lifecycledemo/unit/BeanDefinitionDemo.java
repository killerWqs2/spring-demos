package org.killer.lifecycledemo.unit;

import org.killer.lifecycledemo.entity.User;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author killer
 * @date 2020/11/01 - 14:38
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class).setAutowireMode(1).setLazyInit(false).setScope("singleton")
                .setAbstract(false);

        builder.addPropertyValue("id", 1);

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        defaultListableBeanFactory.registerBeanDefinition("user", builder.getBeanDefinition());

        // defaultListableBeanFactory.registerScope();

        User user = defaultListableBeanFactory.getBean(User.class);

        System.out.println(user);

        // 有意义吗？？ 我现在感觉好难受啊，，一点意义都没有

    }

}
