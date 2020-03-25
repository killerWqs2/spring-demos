package org.killer.redisdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisDemoApplicationTests {

    private RedisTemplate<String, String> redisTemplate;

    // 这就是通过propertiesBeanDefinitionReader来实现的
    private RedisProperties redisProperties;

    @Autowired
    public RedisDemoApplicationTests(RedisTemplate<String, String> redisTemplate, RedisProperties redisProperties) {
        this.redisTemplate = redisTemplate;
        this.redisProperties = redisProperties;
    }

    @Test
    void contextLoads() {
        System.out.println(redisProperties.getHost());

        redisTemplate.opsForValue().append("test", "test");
    }

}
