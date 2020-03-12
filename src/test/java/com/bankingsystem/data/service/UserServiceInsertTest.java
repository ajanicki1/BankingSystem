package com.bankingsystem.data.service;

import com.bankingsystem.domain.exception.UserExistException;
import com.bankingsystem.remote.dto.UserData;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceInsertTest {
    @Autowired
    UserService userService;

    UserData userData = UserData.builder()
            .firstName("Jan")
            .lastName("kowalski")
            .email("jan@gmail.com")
            .login("jan")
            .password("kowalski")
            .balance(BigDecimal.valueOf(1000)).build();

    @Test
    public void insertUserData() throws UserExistException {

        UserData actual = userService.insertUserData(userData);

        assertNotNull(actual.getId());
    }

    @After
    public void removeUserData() {

        assertTrue(userService.removeUserData(userData));
    }


}