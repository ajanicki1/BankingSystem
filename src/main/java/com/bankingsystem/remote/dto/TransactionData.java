package com.bankingsystem.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class TransactionData extends TransferData {

    private Date transactionDate;
    private BigDecimal endingBalance;

}
