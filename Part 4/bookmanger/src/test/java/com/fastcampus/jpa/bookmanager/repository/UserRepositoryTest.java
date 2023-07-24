package com.fastcampus.jpa.bookmanager.repository;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

import com.fastcampus.jpa.bookmanager.domain.Address;
import com.fastcampus.jpa.bookmanager.domain.User;
import com.fastcampus.jpa.bookmanager.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author Martin
 * @since 2021/03/10
 */
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;

    @Test
    @Transactional
    void crud() { // create, read, update, delete

        /*
//        User user = new User();
//        userRepository.save(user);
//
//        userRepository.findAll().forEach(System.out::println);

//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L,3L,5L));
//        users.forEach(System.out::println);

//        User user1 = new User("jack","jack@naver.com");
//        User user2 = new User("jack","jack@naver.com");
//
//        userRepository.saveAll(Lists.newArrayList(user1,user2));
//
//        userRepository.findAll().forEach(System.out::println);

//        User user = userRepository.getOne(1L);
//        System.out.println(user);
//
//        Optional<User> user2 = userRepository.findById(1L);
//        System.out.println(user2);
//
//        User user3 = userRepository.findById(1L).orElse(null);
//        System.out.println(user3);


//        // 저장 후 조회
//        userRepository.save(new User("new martin","martin@naver.com"));
//        userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);
//
//        userRepository.saveAndFlush(new User("new martin","martin@naver.com"));
//        userRepository.findAll().forEach(System.out::println);

//        // 카운드와 여부
//        long count = userRepository.count();
//        System.out.println(count);
//
//        boolean exist = userRepository.existsById(1L);
//        System.out.println(exist);

//        // 삭제
//        // select 후 delete
//        userRepository.deleteById(1L);
//        userRepository.findAll().forEach(System.out::println);

//        userRepository.deleteAll();
//        userRepository.findAll().forEach(System.out::println);

//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        userRepository.findAll().forEach(System.out::println);

//        // select 없이 delete
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L,3L)));
//        userRepository.findAll().forEach(System.out::println);
//
//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);

//        // 페이지 : 원하는 페이지만 골라서 조회
//        Page<User> users = userRepository.findAll(PageRequest.of(1,3));
//
//        System.out.println("page : " + users);
//        System.out.println("totalElements : " + users.getTotalElements());
//        System.out.println("totalPages : " + users.getTotalPages());
//        System.out.println("numberOfElements : " + users.getNumberOfElements());
//        System.out.println("sort : " + users.getSort());
//        System.out.println("size : " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

//        // 예제 엔티티를 활용해 조회하는 방법
//        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withIgnorePaths("name")
//                .withMatcher("email",endsWith());
//
//        Example<User> example = Example.of(new User("ma","fastcapus.com"),matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        userRepository.save(new User("david","david@naver.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-update@naver.com");

        userRepository.save(user);

         */

        userRepository.save(new User("david","david@naver.com"));
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("martin-updated@fastcampus.com");

        userRepository.save(user);
    }

    @Test
    void select(){
//        System.out.println(userRepository.findByName("martin"));
//        System.out.println("findbyemail : " + userRepository.findByEmail("martin@fastcampus.com"));
//        System.out.println("getbyemail : " + userRepository.getByEmail("martin@fastcampus.com"));
//        System.out.println("readbyemail : " + userRepository.readByEmail("martin@fastcampus.com"));
//        System.out.println("querybyemail : " + userRepository.queryByEmail("martin@fastcampus.com"));
//        System.out.println("searchbyemail : " + userRepository.searchByEmail("martin@fastcampus.com"));
//        System.out.println("streambyemail : " + userRepository.streamByEmail("martin@fastcampus.com"));
//        System.out.println("finUserbyemail : " + userRepository.findUserByEmail("martin@fastcampus.com"));

//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(3L));
//        System.out.println("findByAddressListIsNotEmpty : " + userRepository.findByAddressListIsNotEmpty());
        System.out.println(">>> " +
                "findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin","dennis")));
    }

    @Test
    void sortingTest(){
        System.out.println( "findByNameIn : " + userRepository.findTopByNameOrderByIdDesc("martin"));
    }

    @Test
    void listenerTest(){
        User user = new User();
        user.setEmail("martin@fastcampus.com");
        user.setName("martin");

        userRepository.save(user);

        User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user2.setName("marrrrtin");

        userRepository.save(user2);

        userRepository.deleteById(4L);

    }

    @Test
    void prePersistTest(){
        User user = new User();
        user.setName("martin");
        user.setEmail("martin2@fastcampus.com");
        //user.setUpdatedAt(LocalDateTime.now());
        //user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        //System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));
        System.out.println(userRepository.findAll());
    }

    @Test
    void preUpdateTest(){
        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        System.out.println("as-is : " + user);

        user.setName("martin22");
        userRepository.save(user);

        System.out.println("to-be : " + userRepository.findAll().get(0));
    }

    @Test
    void userHistoryTest(){
        User user = new User();
        user.setEmail("martin@naver.com");
        user.setName("martin");;

        userRepository.save(user);

        user.setName("martin_new");

        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);
    }

    @Test
    void userRelationTest(){
        User user = new User();
        user.setName("sand");
        user.setEmail("send@naver.com");

        userRepository.save(user);

        user.setName("kim");
        userRepository.save(user);

        user.setEmail("kim@naver.com");
        userRepository.save(user);

        userHistoryRepository.findAll().forEach(System.out::println);

//        List<UserHistory> result = userHistoryRepository.findByUserId(
//                userRepository.findByEmail("kim@naver.com").getId()
//        );

        List<UserHistory> result = userRepository.findByEmail("kim@naver.com").getUserHistories();

        result.forEach(System.out::println);
    }

    @Test
    void embedTest(){

        User user = new User();
        user.setName("steve");
        user.setHomeAddress(new Address("서울시","강남구","강남대로","12345"));
        user.setCompanyAddress(new Address("서울시","강남구","강남대로","12345"));

        userRepository.save(user);
        userRepository.findAll().forEach(System.out::println);
    }


}
