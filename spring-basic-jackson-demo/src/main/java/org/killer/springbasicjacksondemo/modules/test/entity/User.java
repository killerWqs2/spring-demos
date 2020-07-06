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

}
