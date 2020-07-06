package org.killer.springbasicjacksondemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * 不能理解为什么导入不进去，，
 *
 * @author killer
 * @date 2020/06/15 - 0:05
 */
@Configuration
@ImportResource(locations = {"classpath:META-INF/spring-config.xml"})
public class SpringConfiguration {

}
