package org.killer.jpademo;

import org.junit.jupiter.api.Test;
import org.killer.jpademo.modules.administrator.entity.Administrator;
import org.killer.jpademo.modules.administrator.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaDemoApplicationTests {

    private AdministratorService administratorService;

    @Autowired
    public JpaDemoApplicationTests(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    @Test
    void contextLoads() {

        Administrator killer = new Administrator().setUsername("killer");

        administratorService.register(killer);

    }

}
