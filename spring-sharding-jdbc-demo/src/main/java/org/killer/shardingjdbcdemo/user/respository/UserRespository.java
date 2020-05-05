package org.killer.shardingjdbcdemo.user.respository;

import org.killer.shardingjdbcdemo.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author killer
 * @date 2020/05/04 - 18:55
 */
@Repository
public interface UserRespository extends CrudRepository<User, Integer> { }
