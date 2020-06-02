package org.killer.rocketmqconsumer.unit;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author killer
 * @date 2020/06/01 - 23:52
 */
@SpringBootTest
class ConsumerTest {

    @Autowired
    private DefaultMQPushConsumer consumer;

    @Test
    void test() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
