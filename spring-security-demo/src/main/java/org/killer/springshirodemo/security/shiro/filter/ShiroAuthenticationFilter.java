package org.killer.springshirodemo.security.shiro.filter;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author killer
 * @date 2020/04/04 - 16:44
 */
public class ShiroAuthenticationFilter extends AuthenticatingFilter {

    @Override
    protected Subject getSubject(ServletRequest request, ServletResponse response) {
        return super.getSubject(request, response);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return false;
    }


    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        return null;
    }

}
