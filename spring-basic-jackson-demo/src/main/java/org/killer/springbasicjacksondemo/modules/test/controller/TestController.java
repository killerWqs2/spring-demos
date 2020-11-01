package org.killer.springbasicjacksondemo.modules.test.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.killer.springbasicjacksondemo.CommonResponse;
import org.killer.springbasicjacksondemo.modules.test.entity.Role;
import org.killer.springbasicjacksondemo.modules.test.entity.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

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

    public static void main(String[] args) {
        Role.inner.test();
    }

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {

        ClassPathResource template = new ClassPathResource("template\\模板1.xlsx");

        response.setContentType("application/force-download");
        response.setHeader("Content-Disposition", "attachment; filename="+ template.getFile().getName());

        InputStream inputStream = template.getInputStream();

        byte[] buffer = new byte[1024];

        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            response.getOutputStream().write(buffer, 0, length);
        }

        response.getOutputStream().flush();
        response.getOutputStream().close();

    }

}
