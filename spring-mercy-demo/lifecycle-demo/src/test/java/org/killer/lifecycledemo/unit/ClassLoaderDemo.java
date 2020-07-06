package org.killer.lifecycledemo.unit;

/**
 * @author killer
 * @date 2020/06/10 - 15:27
 */
public class ClassLoaderDemo {

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("org.killer.lifecycledemo.unit.ClassLoaderDemo");

            // 第二次加载同一个类没报错
            Class<?> bClass = Class.forName("org.killer.lifecycledemo.unit.ClassLoaderDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
