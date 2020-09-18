package org.killer.springbasicjacksondemo.modules.test.entity;

public interface Role {

    /** 为什么接口里面内部类可以拥有静态方法*/
    class inner  {
        public static void test() {
            System.out.println("test");
        }
    }

}
