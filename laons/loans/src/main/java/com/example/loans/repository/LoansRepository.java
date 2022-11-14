package com.example.loans.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.loans.model.Loans;

public interface LoansRepository extends JpaRepository<Loans, Long> {
    List<Loans> findByCustomerIdOrderByStartDtDesc(int customerId);
}
