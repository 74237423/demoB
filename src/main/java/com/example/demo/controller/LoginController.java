package com.example.demo.controller;

import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoginController {
    @Autowired
    private StudentService studentService;
    @RequestMapping("/login")
    public String toLoginPage(){
        return "/login.html";
    }
    @RequestMapping("/logout")
    public String returnLoginPage(){
        return "/login.html";
    }
    @RequestMapping(value = "/login.do",method = POST)
    public boolean login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session){
        boolean login =  studentService.login(Integer.parseInt(id),password);
        if (login){
            return true;
        }
        else
            return false;
    }

}
