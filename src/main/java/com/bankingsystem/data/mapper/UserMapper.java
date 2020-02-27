package com.bankingsystem.data.mapper;

import com.bankingsystem.data.user.TransactionEntity;
import com.bankingsystem.data.user.UserEntity;
import com.bankingsystem.remote.dto.TransactionData;
import com.bankingsystem.remote.dto.UserData;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserData mapToUserData(UserEntity userEntity) {
        return UserData
                .builder()
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .email(userEntity.getEmail())
                .balance(userEntity.getBalance())
                .login(userEntity.getLogin())
                .password(userEntity.getPassword())
                .build();
    }

    public UserEntity mapToUserEntity(UserData userData) {
        return UserEntity
                .builder()
                .firstName(userData.getFirstName())
                .lastName(userData.getLastName())
                .email(userData.getEmail())
                .balance(userData.getBalance())
                .login(userData.getLogin())
                .password(userData.getPassword())
                .build();
    }

    public UserEntity mapToUserEntity(UserData userData, UserEntity userEntity) {
        userEntity.setFirstName(userData.getFirstName());
        userEntity.setLastName(userData.getLastName());
        userEntity.setEmail(userData.getEmail());
        userEntity.setBalance(userData.getBalance());
        userEntity.setPassword(userData.getPassword());

        return userEntity;
    }


}
