package com.bankingsystem.remote.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CurrentEquityPrices {

    private List<EquityPrice> equityPrices;

}
