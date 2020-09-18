package org.killer.springbasicjacksondemo.modules.test.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author killer
 * @date 2020/06/10 - 17:21
 */
@Data
@Accessors(chain = true)
public class User {

    @JsonView(User.UserInfo.class)
    private String name;

    // @JsonView(User.UserInfo.class)
    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    public interface UserInfo {}

    // 内部类不能有静态申明, 应该是非静态内部类不能有静态方法，，因为类加载器加载的时候不回去加载非静态类，只有使用的时候才会加载，但是代码里面可以提前使用加载的静态方法，，
    static class inner {
        public static void test() {}
    }

}
