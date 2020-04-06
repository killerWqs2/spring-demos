package org.killer.springshirodemo.security.token;

import org.springframework.security.core.token.Token;

/**
 * @author killer
 * @date 2020/04/05 - 11:11
 */
public class RedisToken implements Token {



    @Override
    public String getKey() {
        return null;
    }

    @Override
    public long getKeyCreationTime() {
        return 0;
    }

    @Override
    public String getExtendedInformation() {
        return null;
    }

}
