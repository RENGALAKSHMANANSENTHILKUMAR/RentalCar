package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


public class FirstController {

     RegisterService userregistration;

    public FirstController(RegisterService userregistration) {
        this.userregistration = userregistration;
    }

    @RequestMapping("/")
    public String display() {
        return "home";
    }


    @RequestMapping("signup")
    public String insertUser(User user, @RequestParam("phonenumber") String phonenumber){

        user.setPhonenumber(phonenumber);
        User useremail =userregistration.checkUserExistance(user.getEmail());
        if (useremail==null)
            userregistration.addUser(user);
        else
            return "redirect:/register";

        return "redirect:/login";
    }


    @RequestMapping("register")
    public String register( ){
        return "register";
    }

   @PostMapping("signin")
   public String  signin(@RequestParam("email")String email, @RequestParam("password")String password) {
        User user=userregistration.verifyUserBasedOnEmail(email,password);
        if (user!=null)
            return "dummy";
        else
            return "login";

    }


    @RequestMapping("login")
    public String login(){
        return "login";
    }


    @RequestMapping("dummy")
    public String dummy(){
        return "dummy";
    }
}