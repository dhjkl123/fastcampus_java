package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Martin
 * @since 2021/03/10
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    List<User> findByEmailAndName(String email, String name);

    List<User> findByIdAfter(Long id);

    //List<User> findByAddressListIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findTop1ByName(String name);

    List<User> findTopByNameOrderByIdDesc(String name);

    Page<User> findByName(String Name, Pageable pageable);





}
