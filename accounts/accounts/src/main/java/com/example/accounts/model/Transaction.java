package com.example.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    private int transactionId;

    private int customerId;

    private int transactionAmount;

    private String transactionType;

    private String transactionDate;

}
