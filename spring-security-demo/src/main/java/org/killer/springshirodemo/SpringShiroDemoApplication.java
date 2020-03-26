package org.killer.springshirodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringShiroDemoApplication {

    @GetMapping("/test")
    public String test() {
        return "hello world!";
    }

    @GetMapping("/security/test")
    public String securityTest() {
        return "security hello world";
    }

    @GetMapping("login")
    public String login() {
        return "assume login";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringShiroDemoApplication.class, args);
    }

}
