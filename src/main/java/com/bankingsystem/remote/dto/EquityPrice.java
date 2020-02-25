package com.bankingsystem.remote.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class EquityPrice {

    private String companyName;
    private BigDecimal price;



}
