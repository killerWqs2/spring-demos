package org.killer.springaopdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringAopDemoApplicationTests {

    @Autowired
    private TestDemo testDemo;

    @Test
    void contextLoads() {

        testDemo.test();

    }

}
