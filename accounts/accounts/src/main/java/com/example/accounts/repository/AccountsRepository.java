package com.example.accounts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accounts.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts findByCustomerId(int customerId);

}
