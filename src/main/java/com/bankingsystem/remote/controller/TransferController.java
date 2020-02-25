package com.bankingsystem.remote.controller;


import com.bankingsystem.remote.dto.TransactionData;
import com.bankingsystem.remote.dto.TransferData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class TransferController {

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody @Valid TransferData transferData) {
        System.out.println(transferData.getAmount());
        System.out.println(transferData.getReceiverEmail());
        System.out.println(transferData.getSenderEmail());
        System.out.println(transferData.getTransferTitle());

        return ResponseEntity.ok().build();
    }

    @GetMapping("/history")
    public ResponseEntity<List<TransactionData>> transactionsHistory(@RequestParam("login") String login) {
        System.out.println(login);

        return ResponseEntity.ok().build();
    }


}
