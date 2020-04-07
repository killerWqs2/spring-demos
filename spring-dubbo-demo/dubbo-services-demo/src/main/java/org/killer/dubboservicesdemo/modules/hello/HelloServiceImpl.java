package org.killer.dubboservicesdemo.modules.hello;

import org.apache.dubbo.config.annotation.Service;
import org.killer.dubbo.sdk.HelloService;

/**
 * @author killer
 * @date 2020/04/07 - 12:24
 */
@Service(version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String say() {
        return "hello world";
    }

}
