package org.killer.springmercydemo.unit.beanDefinition;

import org.killer.springmercydemo.modules.users.entity.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @author killer
 * @date 2020/03/30 - 22:49
 */
public class BeanDefinitionDemo {

    public static void main(String[] args) {
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();

        // 这个实际上就是附加属性，没有太大的意义。
        genericBeanDefinition.setAttribute("source", "mannul");

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        beanDefinitionBuilder.addPropertyValue("nickname", "killerWqs");

        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 设置BeanDefintion的来源。
        genericBeanDefinition.setSource(BeanDefinitionDemo.class);

        defaultListableBeanFactory.registerBeanDefinition("user", beanDefinitionBuilder.getBeanDefinition());
    }

}
