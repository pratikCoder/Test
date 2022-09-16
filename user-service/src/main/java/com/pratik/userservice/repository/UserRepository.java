package com.pratik.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratik.userservice.model.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{

	MyUser findByEmail(String userName);

	MyUser findByUserId(Long userId);

}
