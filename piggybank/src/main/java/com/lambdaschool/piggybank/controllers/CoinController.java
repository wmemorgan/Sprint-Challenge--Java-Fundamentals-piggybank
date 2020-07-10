package com.lambdaschool.piggybank.controllers;

import com.lambdaschool.piggybank.models.Coin;
import com.lambdaschool.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController {

    @Autowired
    CoinRepository coinRepository;

    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> getBankTotal() {
        List<Coin> myList = new ArrayList<>();
        coinRepository.findAll().iterator().forEachRemaining(myList::add);
        double sum = 0;
        for (Coin c : myList) {
            System.out.println(c);
            sum += c.getValue() * c.getQuantity();
        }

        System.out.println("The piggy bank holds " + sum);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
