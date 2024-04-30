package com.example.demo.service;

import com.example.demo.mapper.Mapper;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;

@Service
public class RegisterService {
    private  Mapper Usermapper;

    public RegisterService(Mapper usermapper) {
        Usermapper = usermapper;
    }

    public void addUser(User user){
        Usermapper.registerUser(user);
    }

    //verify user
    public User verifyUserBasedOnEmail(String email, String password){
        return Usermapper.verifyUserBasedOnEmail(email, password);
    }

    //CHECK WHEATHER THE EMAIL ID EXISTS OR NOT FOR REGISTRATION
        public User checkUserExistance(String email){
        return Usermapper.checkUserExistance(email);
        }
}
