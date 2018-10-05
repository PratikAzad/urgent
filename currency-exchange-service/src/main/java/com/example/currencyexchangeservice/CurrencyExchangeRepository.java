package com.example.currencyexchangeservice;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchangeBean,Integer>{

    Optional<CurrencyExchangeBean> findByCurrencyFromAndCurrencyTo(String from, String to);
}
