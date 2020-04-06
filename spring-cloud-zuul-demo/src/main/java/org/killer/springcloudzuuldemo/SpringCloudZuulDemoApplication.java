package org.killer.springcloudzuuldemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

@SpringBootApplication
@EnableDiscoveryClient
// @EnableZuulServer 这个没有内置的反向代理特性
@EnableZuulProxy
public class SpringCloudZuulDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulDemoApplication.class, args);
    }

}
