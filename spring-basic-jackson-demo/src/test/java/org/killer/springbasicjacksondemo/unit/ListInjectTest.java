package org.killer.springbasicjacksondemo.unit;

import org.junit.jupiter.api.Test;
import org.killer.springbasicjacksondemo.modules.test.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE) // 不使用web环境，，
public class ListInjectTest {

    /**spring是可以实现List注入的*/
    @Autowired
    private List<User> users;

    @Test
    public void test() {
        users.forEach(System.out::println);
    }

}
