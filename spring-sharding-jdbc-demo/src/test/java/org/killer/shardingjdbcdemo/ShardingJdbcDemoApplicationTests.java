package org.killer.shardingjdbcdemo;

import org.junit.jupiter.api.Test;
import org.killer.shardingjdbcdemo.user.entity.User;
import org.killer.shardingjdbcdemo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ShardingJdbcDemoApplicationTests {

    private UserService userService;

    @Autowired
    ShardingJdbcDemoApplicationTests(UserService userService) {
        this.userService = userService;
    }

    @Test
    void contextLoads() {

        showUsers();

    }

    private void saveUser() {
        User wqs = new User().setAge(23).setName("wqs");

        userService.save(wqs);

        // 这个时候wqs的id被填充完了吗？
        System.out.println(wqs.getId());
    }

    private void showUsers() {
        List<User> users = userService.showUsers();

        System.out.println("users.length: " + users.size());
        users.forEach(System.out::println);

    }

}
