package org.killer.jpademo.modules.administrator.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author Wu QiaoSheng
 * @description
 * @date 2020-03-26 16:31
 */
@Entity
@Table(name = "administrator")
@Data
@Accessors(chain = true)
public class Administrator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public String username;

    public String phone;

    public String password;

    public String salt;

    public LocalDateTime createTime;

}
