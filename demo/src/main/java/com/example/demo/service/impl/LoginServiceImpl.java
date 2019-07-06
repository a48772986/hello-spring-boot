package com.example.demo.service.impl;

import com.example.demo.entity.Login;
import com.example.demo.service.loginService;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements loginService{

    @Autowired
    loginRepository myRepository;

    @Override
    public List<Login> findAll() {
        return null;
    }

    @Override
    public List<Login> findByUsernameAndUserpassword(String username, String userpassword) {
        return myRepository.findByUsernameAndUserPassword(username,userpassword);
    }

    @Override
    public void save(Login login) {
        myRepository.save(login);
    }

    @Override
    public List<Login> findByUsername(String username) {
        return myRepository.findByUsername(username);
    }

    @Override
    public List<Login> findByEmail(String email,String password){
        return myRepository.findByEmail(email, password);
    }
}
