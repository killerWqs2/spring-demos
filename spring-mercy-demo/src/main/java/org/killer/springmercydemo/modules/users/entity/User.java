package org.killer.springmercydemo.modules.users.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.Serializable;

/**
 * @author killer
 * test1
 * @date 2020/01/30 - 14:10
 */
@Data
@Accessors(chain = true)
@Component
public class User implements Serializable, InitializingBean, BeanNameAware {

    @PostConstruct
    public void init() {
        System.out.println("post construct");
    }

    /**以为被销毁了，所以不可能是PostDestory*/
    @PreDestroy
    public void destory() {
        System.out.println("destory");
    }

    private Long id;

    @Value("${user.nickname:not exist}")
    private String nickname;

    private String phone;

    private String beanName;

    public User() {
    }

    // 用于构造器注入
    public User(Long id, String nickname, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("execute InitializingBean method...");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }

}
