package com.example.currencyexchangeservice;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @Autowired
    private Environment environment;

    @GetMapping("/exchange/from/{from}/to/{to}")
    public CurrencyExchangeBean getExchange(@PathVariable("from")String from,
                                            @PathVariable("to")String to){
        CurrencyExchangeBean currencyExchangeBean = new CurrencyExchangeBean();
        val optional = repository.findByCurrencyFromAndCurrencyTo(from, to);
        if(optional.isPresent()){
            currencyExchangeBean = optional.get();
            currencyExchangeBean.setPort(Integer.parseInt(environment.getProperty("server.port")));
            return currencyExchangeBean;
        }

        return currencyExchangeBean;
    }
}
