package com.bankingsystem.remote.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;



@Getter
@Setter
@Builder
public class UserData {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String password;
    private BigDecimal balance;
}
