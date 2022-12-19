package com.example.loans.controller;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.loans.model.Customer;
import com.example.loans.model.Loans;
import com.example.loans.model.LoansServiceConfig;
import com.example.loans.model.Properties;
import com.example.loans.repository.LoansRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class LoansController {
    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    private LoansServiceConfig laonsConfig;
    private static final org.slf4j.Logger Logger = LoggerFactory.getLogger(LoansController.class);

    @PostMapping("/myLoans")
    public List<Loans> getLoansDetails(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestBody Customer customer) {
        Logger.info("getLoansDetails() method Started");
        List<Loans> loans = loansRepository.findByCustomerIdOrderByStartDtDesc(customer.getCustomerId());
        if (loans != null) {
            Logger.info("getLoansDetails() method Ended");

            return loans;
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/loan/properties", method = RequestMethod.GET, produces = "application/json")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer()
                .withDefaultPrettyPrinter();
        Properties properties = new Properties(laonsConfig.getMsg(), laonsConfig.getBuildVersion(),
                laonsConfig.getMailDetails(), laonsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;

    }

}
