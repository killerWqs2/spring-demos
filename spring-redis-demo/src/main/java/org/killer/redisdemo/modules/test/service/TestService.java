package org.killer.redisdemo.modules.test.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author killer
 * @date 2020/04/11 - 20:43
 */
@Service
public class TestService {

    @Cacheable(cacheNames = "testkey") // 这个注解是作用于方法之上的
    public String test() {
        System.out.println("fetch the original resource");
        return "test";
    }

}
