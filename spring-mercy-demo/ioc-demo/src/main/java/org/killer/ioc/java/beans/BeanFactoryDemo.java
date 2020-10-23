package org.killer.ioc.java.beans;

import java.beans.*;

public class BeanFactoryDemo {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(PersonBean.class);

        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();

        for (MethodDescriptor methodDescriptor : methodDescriptors) {
            System.out.println(methodDescriptor.getMethod());
        }

        System.out.println(Thread.currentThread().getThreadGroup());

        // ThreadGroupContext，， 这个是BeanInfo存储的地方， 并且这个是跟ThreadGroup 挂钩的

        // 如何注册呢？？

        beanInfo.getIcon(1); // java.beans 主要是用来给GUI编程用的，，
    }

}
