package com.fastcampus.bookmanger.repository;

import com.fastcampus.bookmanger.domain.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long> {

}
