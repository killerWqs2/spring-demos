package org.killer.shardingjdbcdemo.user.service;

import org.killer.shardingjdbcdemo.user.entity.User;
import org.killer.shardingjdbcdemo.user.respository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author killer
 * @date 2020/05/04 - 18:59
 */
@Service
public class UserService {

    private final UserRespository userRespository;

    @Autowired
    public UserService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public void save(User user) {
        userRespository.save(user);
    }

    public List<User> showUsers() {

        Iterable<User> it = userRespository.findAll();

        ArrayList<User> users = new ArrayList<>();

        it.forEach(users::add);

        return users;
    }

}
