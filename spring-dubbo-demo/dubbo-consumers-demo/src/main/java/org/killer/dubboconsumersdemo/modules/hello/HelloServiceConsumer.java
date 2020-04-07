package org.killer.dubboconsumersdemo.modules.hello;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;
import org.killer.dubbo.sdk.HelloService;

/**
 * @author killer
 * @date 2020/04/07 - 13:02
 */
@Component
public class HelloServiceConsumer {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    public void say() {
        System.out.println(helloService.say());
    }

}
