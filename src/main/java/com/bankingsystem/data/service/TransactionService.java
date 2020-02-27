package com.bankingsystem.data.service;

import com.bankingsystem.data.mapper.TransactionMapper;
import com.bankingsystem.data.repository.TransactionRepository;
import com.bankingsystem.data.user.TransactionEntity;
import com.bankingsystem.remote.dto.TransactionData;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;
    private TransactionMapper transactionMapper;


    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;

    }


    public List<TransactionData> getTransactionDataListBySenderUserEmail(String senderUserEmail) {
        return transactionRepository.getAllBySenderUserEmail(senderUserEmail)
                .stream()
                .map(transactionEntity -> transactionMapper
                        .mapToTransactionData(transactionEntity))
                .collect(Collectors.toList());


    }

    public List<TransactionData> getTransactionDataListByReceiverUserEmail(String receiverUserEmail) {
        return transactionRepository.getAllByReceiverUserEmail(receiverUserEmail)
                .stream()
                .map(transactionEntity -> transactionMapper
                        .mapToTransactionData(transactionEntity))
                .collect(Collectors.toList());

    }

    public TransactionData insertTransactionData(TransactionData transactionData) {
        TransactionEntity transactionEntity = transactionMapper.mapToTransactionEntity(transactionData);
        transactionEntity = transactionRepository.save(transactionEntity);
        return transactionMapper.mapToTransactionData(transactionEntity);

    }

    public boolean deleteAllTransactionDataBySenderEmail(String senderUserEmail) {

        List<TransactionEntity> transactionList = transactionRepository.getAllBySenderUserEmail(senderUserEmail);

        if (transactionList.isEmpty()) {
            return false;
        }
        transactionList.forEach(transactionEntity -> transactionRepository.delete(transactionEntity));

        return true;


    }

}
