package org.killer.springbasicjacksondemo.modules.test.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author killer
 * @date 2020/06/14 - 22:23
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Administrator extends User {

    private String roleName;

}
