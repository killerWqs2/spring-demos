package org.killer.lifecycledemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author killer
 * @date 2020/06/09 - 22:26
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;

    private String name;

    private Integer age;

}
