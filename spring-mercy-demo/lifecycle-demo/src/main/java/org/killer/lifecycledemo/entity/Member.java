package org.killer.lifecycledemo.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author killer
 * @date 2020/10/26 - 22:25
 */
@Data
@Accessors(chain = true)
public class Member extends User {

    private int level;

}
