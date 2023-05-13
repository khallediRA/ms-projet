package com.example.accounts.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.accounts.model.Customer;
import com.example.accounts.model.Transaction;
import java.util.List;

@FeignClient("transactions")
public interface TransactionsFeignClient {
    @RequestMapping(method = RequestMethod.POST, value = "myTransactions", consumes = "application/json")
    List<Transaction> getAllTransactions(@RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestBody Customer customer);

}
