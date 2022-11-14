package com.example.accounts.model;

import java.time.LocalDate;

import javax.persistence.Entity;

import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Accounts {
    private int customerId;
    @Id
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
    private LocalDate createDt;

}
