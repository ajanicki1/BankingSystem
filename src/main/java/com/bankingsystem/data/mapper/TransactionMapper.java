package com.bankingsystem.data.mapper;

import com.bankingsystem.data.user.TransactionEntity;
import com.bankingsystem.remote.dto.TransactionData;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionData mapToTransactionData(TransactionEntity transactionEntity) {
        TransactionData transactionData = new TransactionData();
        transactionData.setTransactionDate(transactionEntity.getTransactionDate());
        transactionData.setEndingBalance(transactionEntity.getEndingBalance());
        transactionData.setSenderEmail(transactionEntity.getSenderUserEmail());
        transactionData.setReceiverEmail(transactionEntity.getReceiverUserEmail());
        transactionData.setAmount(transactionEntity.getAmount());
        transactionData.setTransferTitle(transactionEntity.getTransferTitle());

        return transactionData;
    }

    public TransactionEntity mapToTransactionEntity(TransactionData transactionData) {

        return TransactionEntity.builder()
                .transactionDate(transactionData.getTransactionDate())
                .endingBalance(transactionData.getEndingBalance())
                .senderUserEmail(transactionData.getSenderEmail())
                .receiverUserEmail(transactionData.getReceiverEmail())
                .amount(transactionData.getAmount())
                .transferTitle(transactionData.getTransferTitle())
                .build();
    }
}
