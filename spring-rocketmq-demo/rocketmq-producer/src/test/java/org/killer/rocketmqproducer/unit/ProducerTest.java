package org.killer.rocketmqproducer.unit;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author killer
 * @date 2020/06/01 - 22:23
 */
@SpringBootTest
class ProducerTest {

    @Autowired
    DefaultMQProducer producer;

    @Test
    void test() {
        try {
            producer.send(new Message("test", "hello, girl!".getBytes()));
        } catch (MQClientException | RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
