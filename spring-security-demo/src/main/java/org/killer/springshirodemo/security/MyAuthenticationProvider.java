package org.killer.springshirodemo.security;

import org.killer.springshirodemo.security.exception.PasswordErrorException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author killer
 * @description 我一直有点好奇，spring security的session是存储在哪里的呢，扩展点在哪儿
 * @date 2020/04/04 - 21:02
 */
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    private MyUserService userService;

    public MyAuthenticationProvider(MyUserService userService) {
        this.userService = userService;
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        // 校验， userDetails 是从数据库中取出的信息， authentication是从client提取出的需要认证的信息
        if(!userDetails.getPassword().equals(authentication.getCredentials())) {
            throw new PasswordErrorException("password error");
        }

        // 其实我一直不太清楚，为什么当前authentication会被抛弃，而重新创建一个authentication
    }

    @Override
    protected UserDetails retrieveUser(String phone, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return userService.loadUserByUsername(phone);
    }

}
