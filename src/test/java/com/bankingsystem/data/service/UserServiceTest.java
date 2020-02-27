package com.bankingsystem.data.service;

import com.bankingsystem.remote.dto.UserData;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;


    @Test
    public void insertUserData() {

        UserData userData = UserData.builder().firstName("Jan").lastName("kowalski").email("jan@gmail.com").login("jan").password("kowalski").balance(BigDecimal.valueOf(1000)).build();

        userService.insertUserData(userData);



    }
}