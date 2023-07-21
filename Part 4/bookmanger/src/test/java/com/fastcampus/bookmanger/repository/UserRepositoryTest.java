package com.fastcampus.bookmanger.repository;

import com.fastcampus.bookmanger.domain.MyUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MyUserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud(){ // create read update delete

        System.out.println(">>>");
        userRepository.save(new MyUser());

        System.out.println(">>>" + userRepository.findAll());
    }
}