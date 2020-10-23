package org.killer.ioc.java.beans;

import lombok.Data;

import java.beans.JavaBean;

@Data
@JavaBean
public class PersonBean {

    private String name;

    private Integer age;

}
