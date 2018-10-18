package com.example.currencyexchangeservice.repository;

import com.example.currencyexchangeservice.domain.CurrencyExchangeBean;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchangeBean,String> {

    Optional<CurrencyExchangeBean> findByCurrencyFromAndCurrencyTo(String currencyFrom,
                                                                   String currencyTo);
}
