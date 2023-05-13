package com.example.transactions.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.transactions.model.Transaction;
import com.example.transactions.model.TransactionsServiceConfig;
import com.example.transactions.model.Customer;
import com.example.transactions.model.Properties;
import com.example.transactions.repository.TransactionsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class TransactionsController {
    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private TransactionsServiceConfig transactionsConfig;
    private static final Logger Logger = LoggerFactory.getLogger(TransactionsController.class);

    @PostMapping("/myTransactions")
    public List<Transaction> gettransactionDetails(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestBody Customer customer) {
        Logger.info("gettransactionDetails() method started");
        List<Transaction> transactions = transactionsRepository.findByCustomerId(customer.getCustomerId());
        if (transactions != null) {
            Logger.info("gettransactionDetails() method ended");

            return transactions;
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/transactions/properties", method = RequestMethod.GET, produces = "application/json")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer()
                .withDefaultPrettyPrinter();
        Properties properties = new Properties(transactionsConfig.getMsg(), transactionsConfig.getBuildVersion(),
                transactionsConfig.getMailDetails(), transactionsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;

    }
}
