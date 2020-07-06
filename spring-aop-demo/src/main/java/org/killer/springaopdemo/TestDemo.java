package org.killer.springaopdemo;

import lombok.extern.java.Log;
import org.killer.springaopdemo.aspects.test.annotation.Transactional;
import org.springframework.stereotype.Component;

/**
 * @author killer
 * @date 2020/07/06 - 14:30
 */
@Component
@Log
public class TestDemo {

    @Transactional
    public void test() {
        log.info("test");
    }

}
