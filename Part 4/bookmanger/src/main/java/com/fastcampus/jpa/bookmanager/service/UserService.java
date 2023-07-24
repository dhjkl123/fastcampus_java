package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private EntityManager entityManager;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void put(){
        User user = new User();
        user.setName("asdf");
        user.setEmail("asdf@naver.com");

        entityManager.persist(user);
        entityManager.detach(user);

        user.setName("asdfqwer");

        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.clear();

        entityManager.remove(user);

        User user1 = userRepository.findById(1L).get();
        entityManager.remove(user1);

        user1.setName("zxczxc");
        entityManager.merge(user1);

    }
}
