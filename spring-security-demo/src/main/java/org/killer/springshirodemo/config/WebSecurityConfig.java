package org.killer.springshirodemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Wu QiaoSheng
 * @description
 * @date 2020-03-26 13:05
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void init(WebSecurity web) throws Exception {
        super.init(web);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // super.configure(http);
        // http.requestMatchers().antMatchers();
        http.antMatcher("/security/*").authorizeRequests().antMatchers("/security/test").authenticated()
                // ExceptionTranslatorFilter 主要是用来处理 ExpressionInterceptor 抛出来的异常, 其实我就好奇为什么默认的登录页面没有装载上去
                .and().formLogin().and().httpBasic();

    }

}
