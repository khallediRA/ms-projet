package com.example.transactions.model;

import javax.persistence.Entity;

import lombok.Data;

import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "transaction")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Transaction_id")
    private int transactionId;

    @Column(name = "Customer_id")
    private int customerId;

    @Column(name = "Transaction_amount")
    private int transactionAmount;

    @Column(name = "Transaction_type")
    private String transactionType;

    @Column(name = "Transaction_date")
    private String transactionDate;
}
