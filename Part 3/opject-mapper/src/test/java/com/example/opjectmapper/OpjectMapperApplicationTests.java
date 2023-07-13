package com.example.opjectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("-----");

        //Text Json -> Object
        //Object -> Text Json

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text 일 때, get method를 활용한다.

        //Object -> Text Json
        User user = new User("steve",10,"010-9999-8888");

        var text = objectMapper.writeValueAsString(user);

        System.out.println(text);

        //text -> object 일 때, default 생성자를 사용한다.
        var objectUser = objectMapper.readValue(text,User.class);
        System.out.println(objectUser);

    }

}
