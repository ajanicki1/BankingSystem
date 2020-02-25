package com.bankingsystem.remote.controller;

import com.bankingsystem.remote.dto.Currencies;
import com.bankingsystem.remote.dto.CurrentEquityPrices;
import com.bankingsystem.remote.dto.TransactionData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

    @GetMapping("/currencies")
    public ResponseEntity<Currencies> currenciesExchangeRates() {

        // TODO
        return ResponseEntity.ok().build();
    }
    @GetMapping("/equity")
    public ResponseEntity<CurrentEquityPrices> equityPrices() {

        // TODO
        return ResponseEntity.ok().build();
    }



}
