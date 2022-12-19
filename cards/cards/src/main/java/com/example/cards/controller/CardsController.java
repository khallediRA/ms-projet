package com.example.cards.controller;

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

import com.example.cards.model.Cards;
import com.example.cards.model.CardsServiceConfig;
import com.example.cards.model.Customer;
import com.example.cards.model.Properties;
import com.example.cards.repository.CardsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RestController
public class CardsController {
    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private CardsServiceConfig cardsConfig;
    private static final Logger Logger = LoggerFactory.getLogger(CardsController.class);

    @PostMapping("/myCards")
    public List<Cards> getCardDetails(
            @RequestHeader("eazybank-correlation-id") String correlationId,
            @RequestBody Customer customer) {
        Logger.info("getCardDetails() method started");
        List<Cards> cards = cardsRepository.findByCustomerId(customer.getCustomerId());
        if (cards != null) {
            Logger.info("getCardDetails() method ended");

            return cards;
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/cards/properties", method = RequestMethod.GET, produces = "application/json")
    public String getPropertyDetails() throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer()
                .withDefaultPrettyPrinter();
        Properties properties = new Properties(cardsConfig.getMsg(), cardsConfig.getBuildVersion(),
                cardsConfig.getMailDetails(), cardsConfig.getActiveBranches());
        String jsonStr = ow.writeValueAsString(properties);
        return jsonStr;

    }
}
