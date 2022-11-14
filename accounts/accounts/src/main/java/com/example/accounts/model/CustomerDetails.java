package com.example.accounts.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {
    private Accounts accounts;
    private List<Loan> loans;
    private List<Card> cards;
}
