package com.example.currencyexchangeservice.controller;

import com.example.currencyexchangeservice.domain.CurrencyExchangeBean;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;
import com.fasterxml.jackson.annotation.OptBoolean;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Slf4j
public class CurrencyExchangeController {

	Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    @Autowired
    private CurrencyExchangeRepository repository;
    @Autowired
    private Environment environment;

    @GetMapping("/exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchangeBean> getExchangeRate(@PathVariable("from")String from,
                                                                @PathVariable("to") String to){
        val exchangeOptional = repository.findByCurrencyFromAndCurrencyTo(from,to);
        if(exchangeOptional.isPresent()) {
            CurrencyExchangeBean currencyExchangeBean = exchangeOptional.get();
            currencyExchangeBean.setPort(Integer.parseInt(
                    environment.getProperty("server.port")));
            
            //log.info("{}",exchangeOptional.get());
            logger.info("exchange url called...");
            return ResponseEntity.ok(exchangeOptional.get());
        }
        else
            return ResponseEntity.notFound().build();
    }
}
