package com.bankingsystem.data.repository;


import com.bankingsystem.data.user.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    List<TransactionEntity> getAllBySenderUserEmail(String email);

    List<TransactionEntity> getAllByReceiverUserEmail(String email);

}
