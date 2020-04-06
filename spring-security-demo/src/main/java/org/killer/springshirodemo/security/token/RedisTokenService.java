package org.killer.springshirodemo.security.token;

import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;

/**
 * @author killer
 * @date 2020/04/05 - 11:08
 */
public class RedisTokenService implements TokenService {

    @Override
    public Token allocateToken(String extendedInformation) {
        return null;
    }

    @Override
    public Token verifyToken(String key) {
        return null;
    }

}
