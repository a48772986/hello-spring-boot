package com.example.demo.repository;

import com.example.demo.entity.Login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface loginRepository  extends JpaRepository<Login,Integer>, JpaSpecificationExecutor<Login>{
    @Query(value = "select * from login  where username=?1 and userpassword=?2",nativeQuery = true)
    List<Login> findByUsernameAndUserPassword(String username, String userPassword);

    List<Login> findAll();

    @Query(value = "select * from login  where username=?1", nativeQuery = true)
    List<Login> findByUsername(String username);

    @Query(value = "select * from login where email=?1 and userpassword=?2", nativeQuery = true)
    List<Login> findByEmail(String email,String password);
}
