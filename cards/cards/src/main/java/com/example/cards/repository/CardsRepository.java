package com.example.cards.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.cards.model.Cards;

public interface CardsRepository extends CrudRepository<Cards, Long> {

    List<Cards> findByCustomerId(int customerId);

}
