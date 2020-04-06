package org.killer.springshirodemo.security;

import org.killer.springshirodemo.security.token.RedisTokenService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author killer
 * @description
 * @date 2020/04/05 - 11:00
 */
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private TokenService tokenService = new RedisTokenService();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        // 这个authentication应该是最新的
        response.addCookie(new Cookie("token", tokenService.allocateToken(authentication.getName()).getKey()));

        // 这个本来是用来重定向到初始登录url的
        super.onAuthenticationSuccess(request, response, authentication);
    }

}
