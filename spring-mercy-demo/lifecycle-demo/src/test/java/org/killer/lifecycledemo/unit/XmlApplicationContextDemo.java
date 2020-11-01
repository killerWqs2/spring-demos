package org.killer.lifecycledemo.unit;

import org.killer.lifecycledemo.entity.User;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author killer
 * @date 2020/10/26 - 22:28
 */
// @SpringBootTest
public class XmlApplicationContextDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/spring-context.xml");

        Map<String, User> beansOfType = classPathXmlApplicationContext.getBeansOfType(User.class);

        beansOfType.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });

    }

}
