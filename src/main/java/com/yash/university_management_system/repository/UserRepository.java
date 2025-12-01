package com.yash.university_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.yash.university_management_system.entity.YashLogin;


public interface UserRepository extends JpaRepository<YashLogin, Integer>{

    @Query(value = "Select * from yash_login", nativeQuery = true)
    List<YashLogin> findAllAdmin();

    @Query(value = "SELECT * FROM yash_login WHERE username = :username", nativeQuery = true)
    YashLogin findByUsername(@Param("username") String username);

}
