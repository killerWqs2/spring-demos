package org.killer.springshirodemo.security;

import org.killer.jpademo.modules.administrator.entity.Administrator;
import org.killer.jpademo.modules.administrator.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Wu QiaoSheng
 * @description
 *
 * @date 2020-03-26 15:03
 */
public class MyUserService implements UserDetailsService {

    @Autowired
    private AdministratorService administratorService;

    @Override
    public UserDetails loadUserByUsername(String phone) throws UsernameNotFoundException {
        // 传进来的依旧是手机号码
        Administrator administrator = administratorService.loadAdministratorByPhone(phone);

        return new User(administrator.getPhone(), administrator.getPassword(), null);

    }

}
