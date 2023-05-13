package com.example.transactions.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.transactions.model.Transaction;

public interface TransactionsRepository extends CrudRepository<Transaction, Long> {

    List<Transaction> findByCustomerId(int customerId);

}

