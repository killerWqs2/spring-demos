package org.killer.jpademo.modules.administrator.repository;

import org.killer.jpademo.modules.administrator.entity.Administrator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Wu QiaoSheng
 * @description 我也是需要继承接口, 这个repository就相当于mybatis中的mapper
 * @date 2020-03-26 16:47
 */
@Repository
public interface AdministratorRepository extends CrudRepository<Administrator, Integer> {

    /**
     * 通过Id获取用户
     * @param id 用户id
     * @return 返回多个用户
     */
    List<Administrator> getAdministratorById(Integer id);


    /**
     * @param phone 手机号
     * @return single administrator
     */
    Administrator findAdministratorByPhone(String phone);

}
