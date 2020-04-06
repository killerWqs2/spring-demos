package org.killer.springshirodemo.security.exception;

import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;

/**
 * @author killer
 * @date 2020/04/05 - 10:41
 */
public class PasswordErrorException extends AuthenticationException {

    public PasswordErrorException(String msg) {
        super(StringUtils.isEmpty(msg) ? "password error" : msg);
    }

}
