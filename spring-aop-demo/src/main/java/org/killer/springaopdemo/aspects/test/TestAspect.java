package org.killer.springaopdemo.aspects.test;

import lombok.extern.java.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.killer.springaopdemo.aspects.test.annotation.Transactional;
import org.springframework.stereotype.Component;

/**
 * @author killer
 * @date 2020/07/06 - 14:21
 */
@Component
@Aspect
@Log
public class TestAspect {

    @Pointcut(value = "@annotation(org.killer.springaopdemo.aspects.test.annotation.Transactional)")
    public void pointCut() {}

    /**
     *  需要解决一个问题就是如何获取注解里面的参数, 这个语法是怎么回事呢
     *  暂时只能理解为传入不匹配的，会当做参数， 比如 args(a,b)
     */
    @Before(value = "pointCut()&&@annotation(transactional)")
    public void before(JoinPoint joinPoint, Transactional transactional) {
        log.info("before " + transactional.value());
    }

}
