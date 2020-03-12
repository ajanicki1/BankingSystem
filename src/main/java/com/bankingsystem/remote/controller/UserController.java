package com.bankingsystem.remote.controller;

import com.bankingsystem.domain.exception.UserExistException;
import com.bankingsystem.domain.usecase.RegisterUsecase;
import com.bankingsystem.remote.dto.LoginData;
import com.bankingsystem.remote.dto.RegisterData;
import com.bankingsystem.remote.validator.RegisterDataValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    private RegisterDataValidator loginDataValidator;
    private RegisterUsecase registerUsecase;


    public UserController(RegisterDataValidator loginDataValidator, RegisterUsecase registerUsecase) {
        this.loginDataValidator = loginDataValidator;
        this.registerUsecase = registerUsecase;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterData registerData) {
        try {
            registerUsecase.register(registerData);
            return new ResponseEntity<>("User is registered", HttpStatus.CREATED);
        } catch (UserExistException e) {
            return new ResponseEntity<>("User exists", HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginData loginData) {
        System.out.println(loginData.getLogin());
        System.out.println(loginData.getPassword());
        return "User logged in";
    }


}
