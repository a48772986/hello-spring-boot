package com.example.demo.controller;

import com.example.demo.service.loginService;

import com.example.demo.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class loginController {
    @Autowired
    loginService loginService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }
    @RequestMapping(value = "/registers",method = RequestMethod.GET)
    public ModelAndView registers(){
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    //登陆功能
    @PostMapping("/login")
    public ModelAndView Login(@RequestParam("email") String email,@RequestParam("userpassword") String userpassword){
        List<Login> login= loginService.findByEmail(email,userpassword);

        System.out.println(email +":"+userpassword);
        //System.out.println(login);
        ModelAndView success = new ModelAndView();
        if(login.size()>0){
            success.setViewName("success");
        } else {
            success.setViewName("404");
        }
        success.addObject("username",login.get(0).getUsername());
        success.addObject("email",login.get(0).getEmail());
        success.addObject("pic_path",login.get(0).getImg_path() == null ? "timg.jpg" : login.get(0).getImg_path() );
        return success;
    }
    //注册功能
    @PostMapping("/register")
    public ModelAndView register(@RequestParam("username") String username,@RequestParam("password")
            String password,@RequestParam("email") String email){
        ModelAndView success = new ModelAndView();
        //用户或密码为空的条件判断
        if(username.isEmpty()||password.isEmpty()){
            success.setViewName("register");
            success.addObject("tip1","用户或密码不能为空");
            return success;
        }

        //判断是否取到用户，如果没有就保存在数据库中
        List<Login> us=loginService.findByUsername(username);
        if(us.size()==0){
            //List<Login> register=loginService.save(username,password);
            Login registers=new Login();
            registers.setUserpassword(password);
            registers.setUsername(username);
            registers.setEmail(email);
            loginService.save(registers);
            success.setViewName("success");
        }
        else {
            success.setViewName("404");
        }
        return success;
    }

}
