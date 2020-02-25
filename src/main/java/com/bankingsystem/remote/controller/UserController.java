package com.bankingsystem.remote.controller;

import com.bankingsystem.remote.dto.LoginData;
import com.bankingsystem.remote.dto.RegisterData;
import com.bankingsystem.remote.validator.RegisterDataValidator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private RegisterDataValidator loginDataValidator;


    public UserController(RegisterDataValidator loginDataValidator) {
        this.loginDataValidator = loginDataValidator;
    }

    @PostMapping("/register")
    public String register(@RequestBody @Valid RegisterData registerData) {
        System.out.println(registerData.getFirstName());
        System.out.println(registerData.getLastName());
        System.out.println(registerData.getEmail());
        System.out.println(registerData.getLogin());
        System.out.println(registerData.getPassword());
        return "User is registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginData loginData) {
        System.out.println(loginData.getLogin());
        System.out.println(loginData.getPassword());
        return "User logged in";
    }




}
