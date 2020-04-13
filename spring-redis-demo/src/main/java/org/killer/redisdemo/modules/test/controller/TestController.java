package org.killer.redisdemo.modules.test.controller;

import lombok.AllArgsConstructor;
import org.killer.redisdemo.modules.test.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author killer
 * @date 2020/04/11 - 20:43
 */
@RestController
@AllArgsConstructor
public class TestController {

    private TestService testService;

    @GetMapping("test")
    public String test() {
        return testService.test();
    }

}
