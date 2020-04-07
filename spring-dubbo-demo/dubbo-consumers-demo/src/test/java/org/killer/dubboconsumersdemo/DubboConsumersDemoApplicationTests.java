package org.killer.dubboconsumersdemo;

import org.junit.jupiter.api.Test;
import org.killer.dubboconsumersdemo.modules.hello.HelloServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DubboConsumersDemoApplicationTests {

    @Autowired
    private HelloServiceConsumer helloServiceConsumer;

    @Test
    void contextLoads() {
        helloServiceConsumer.say();
    }

}
