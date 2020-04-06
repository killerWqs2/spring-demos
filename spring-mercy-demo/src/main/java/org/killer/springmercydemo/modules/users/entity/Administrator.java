package org.killer.springmercydemo.modules.users.entity;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author killer
 * @date 2020/02/19 - 12:41
 */

@Component
@Primary
public class Administrator extends User {

    private boolean isAdmin;

    /** 为什么这里一定要注入呢？？ 没有标注@Autowird */
    public Administrator(Long id, String nickname, String phone) {
        super(id, nickname, phone);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

}
