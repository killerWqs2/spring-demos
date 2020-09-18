package org.killer.springbasicjacksondemo.modules.test.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Boss extends User{

    private boolean fat;

}
