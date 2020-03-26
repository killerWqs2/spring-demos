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
public class UserService implements UserDetailsService {

    private AdministratorService administratorService;

    @Autowired
    public UserService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorService.loadUserByUsername(username);
        return new User(administrator.getUsername(), administrator.getPassword(), null);
    }

}
