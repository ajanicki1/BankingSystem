package com.bankingsystem.data.service;

import com.bankingsystem.domain.exception.UserExistException;
import com.bankingsystem.remote.dto.UserData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceUpdateTest {

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
    public void updateUserData() throws UserExistException {

        userService.insertUserData(userData);
        UserData updatedUserData = UserData.builder().firstName("Jan")
                .lastName("Polanski")
                .email("polanski@gmail.com")
                .login("jan").password("polanski123")
                .balance(BigDecimal.valueOf(2500)).build();

        boolean wasUpdated = userService.updateUserData(updatedUserData);

        assertTrue(wasUpdated);

        Optional<UserData> actual = userService.getUserByLogin(updatedUserData.getLogin());
        assertTrue(actual.isPresent());

        assertEquals(updatedUserData.getFirstName(), "Jan");
        assertEquals(updatedUserData.getLastName(), "Polanski");
        assertEquals(updatedUserData.getBalance(), BigDecimal.valueOf(2500));
        assertEquals(updatedUserData.getEmail(), "polanski@gmail.com");
        assertEquals(updatedUserData.getPassword(), "polanski123");
    }

    @After
    public void removeUserData() {

        assertTrue(userService.removeUserData(userData));
    }


}
