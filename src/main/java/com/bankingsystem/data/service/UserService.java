package com.bankingsystem.data.service;


import com.bankingsystem.data.mapper.UserMapper;
import com.bankingsystem.data.repository.UserRepository;
import com.bankingsystem.data.user.UserEntity;
import com.bankingsystem.remote.dto.UserData;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Optional<UserData> getUserByLogin(String login) {
        return userRepository
                .getByLogin(login)
                .map(userEntity -> userMapper.mapToUserData(userEntity));
    }

    public UserData insertUserData(UserData userData) {
        Optional<UserEntity> optionalUserEntity = userRepository.getByLogin(userData.getLogin());
        if (optionalUserEntity.isPresent())
        {
            //TODO change this to throw exception
            return userData;
        }
        UserEntity userEntity = userMapper.mapToUserEntity(userData);
        userEntity = userRepository.save(userEntity);
        return userMapper.mapToUserData(userEntity);
    }

    public boolean updateUserData(UserData userData) {

        Optional<UserEntity> userEntityOptional = userRepository.getByLogin(userData.getLogin());

        if (userEntityOptional.isEmpty()) {
            return false;
        }

        UserEntity userEntity = userMapper.mapToUserEntity(userData, userEntityOptional.get());
        userRepository.save(userEntity);
        return true;
    }

    public boolean removeUserData(UserData userData) {
        Optional<UserEntity> userEntityOptional = userRepository.getByLogin(userData.getLogin());

        if (userEntityOptional.isEmpty()) {
            return false;
        }
        userRepository.delete(userEntityOptional.get());
        return true;
    }

}
