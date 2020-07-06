package org.killer.springbasicjacksondemo.modules.test.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.killer.springbasicjacksondemo.CommonResponse;
import org.killer.springbasicjacksondemo.modules.test.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author killer
 * @date 2020/06/10 - 17:16
 */
@RestController
public class TestController {

    /** 校验 jsonView 生效情况 ， 在返回值是map的情况下， 所有view都是有效返回的*/
    @GetMapping("test")
    @JsonView(User.UserInfo.class)
    public CommonResponse<User> test() {

        User user = new User();
        user.setAge(23);
        user.setName("wqs");

        return CommonResponse.success(user);
    }

}
