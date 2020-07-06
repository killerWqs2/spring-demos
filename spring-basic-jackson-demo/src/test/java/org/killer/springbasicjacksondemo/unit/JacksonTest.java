package org.killer.springbasicjacksondemo.unit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.killer.springbasicjacksondemo.modules.test.entity.User;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author killer
 * @date 2020/06/14 - 21:51
 */
class JacksonTest {

    @Test
    void test() {
        ObjectMapper objectMapper = new ObjectMapper();
        User wqs = new User().setAge(23).setName("wqs").setBirthday(LocalDate.now()).setCreateTime(new Date());

        // 怎么判断的呢，，
        try {
            System.out.println(objectMapper.writeValueAsString(wqs));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
