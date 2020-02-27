package com.bankingsystem.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "transactions")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "senderUserEmail")
    private String senderUserEmail;
    @Column(name = "receiverUserEmail")
    private String receiverUserEmail;

    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "transferTitle")
    private String transferTitle;
    @Column(name = "transactionDate")
    private Date transactionDate;
    @Column(name = "endingBalance")
    private BigDecimal endingBalance;


}
