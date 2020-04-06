package org.killer.springshirodemo.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.killer.springshirodemo.security.shiro.UserRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author killer
 * @date 2020/04/04 - 16:36
 */
@Configuration
public class ShiroConfig {

    // 这个主要是用来使用非HttpSession 作为存储的， 这个应该是使用自己的session实现来完成， 可以通过这个实现自己的session机制，such as session外部化存储
    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        // 设置session过期清除机制吧
        sessionManager.setSessionValidationSchedulerEnabled(true);
        //
        sessionManager.setSessionIdCookieEnabled(true);

        return sessionManager;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager defaultSecurityManager = new DefaultWebSecurityManager();

        defaultSecurityManager.setRealm(new UserRealm());

        defaultSecurityManager.setSessionManager(sessionManager());

        return defaultSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter() throws Exception {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(securityManager());

        // shiroFilterFactoryBean.setLoginUrl("/login");
        //
        // shiroFilterFactoryBean.setSuccessUrl("/index");
        //
        // shiroFilterFactoryBean.setUnauthorizedUrl("/login.html");

        // shiroFilterFactoryBean.setFilterChainDefinitionMap();
        return shiroFilterFactoryBean;
    }

}
