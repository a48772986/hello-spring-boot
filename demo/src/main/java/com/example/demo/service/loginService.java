package com.example.demo.service;

import com.example.demo.entity.Login;
import java.util.List;

public interface loginService {
    List<Login> findAll();

    List<Login> findByUsernameAndUserpassword(String username , String userpassword);

    void save(Login login);

    List<Login> findByUsername(String username);

    List<Login> findByEmail(String email,String password);
}
