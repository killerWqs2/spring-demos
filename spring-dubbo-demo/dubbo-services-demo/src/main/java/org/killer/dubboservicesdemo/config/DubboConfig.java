package org.killer.dubboservicesdemo.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;

/**
 * @author killer
 * @date 2020/04/07 - 12:22
 */
@Configuration
@EnableDubbo(scanBasePackages = "org.killer.dubboservicesdemo.modules")
public class DubboConfig {

}
