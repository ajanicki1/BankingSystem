package com.bankingsystem.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class TransferData {

    private String senderEmail;
    private String receiverEmail;
    private BigDecimal amount;
    private String transferTitle;


}
