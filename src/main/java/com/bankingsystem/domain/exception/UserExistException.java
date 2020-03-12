package com.bankingsystem.domain.exception;

public class UserExistException extends Throwable {

    public UserExistException(String message) {
        super(message);
    }
}
