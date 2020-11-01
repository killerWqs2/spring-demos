package org.killer.java.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * @author killer
 * @date 2020/10/22 - 23:02
 */
public class PersonInfoDemo {

    public static void main(String[] args) throws IntrospectionException {
        // 这里需要注册吗？
        // 这里就相当于得到了一个BeanDefinition，，BeanInfo,,
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor);
        }


    }

}
