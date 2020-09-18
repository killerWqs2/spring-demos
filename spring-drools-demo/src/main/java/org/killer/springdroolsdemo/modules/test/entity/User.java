package org.killer.springdroolsdemo.modules.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

@Data
@Accessors(chain = true)
public class User {

    private String name;

    private Integer age;

    private Float salary;

    private Integer level;

    private Date createTime;

    private LocalDate birthday;

    private Boolean teenager;

}
