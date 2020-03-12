package com.bankingsystem.domain.usecase;


import com.bankingsystem.data.service.UserService;
import com.bankingsystem.domain.config.AccountConfirguration;
import com.bankingsystem.domain.exception.UserExistException;
import com.bankingsystem.remote.dto.RegisterData;
import com.bankingsystem.remote.dto.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUsecase {

    @Autowired
    private UserService userService;

    public RegisterUsecase(UserService userService) {
        this.userService = userService;

    }

    public void register(RegisterData registerData) throws UserExistException {
        UserData userData = UserData.builder().firstName(registerData.getFirstName())
                .lastName(registerData.getLastName())
                .login(registerData.getLogin())
                .password(registerData.getPassword())
                .email(registerData.getEmail())
                .balance(AccountConfirguration.STARTING_ACCOUNT_BALANCE)
                .build();

        userService.insertUserData(userData);

    }

    public void updateRegisterData()
    {

        //TODO Create in userController
    }


}
