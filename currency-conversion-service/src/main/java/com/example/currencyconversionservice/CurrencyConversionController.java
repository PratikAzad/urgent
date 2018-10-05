package com.example.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {


//    @GetMapping("/exchangeAmount/from/{from}/to/{to}/qty/{qty}")
//    public CurrencyConversionBean getConvertedAmount(@PathVariable("from")String from,
//                                                     @PathVariable("to")String to,
//                                                     @PathVariable("qty")double qty){
//
//        CurrencyConversionBean currencyConversionBean = new RestTemplate()
//                .getForObject("http://localhost:8001/exchange/from/{from}/to/{to}",
//                CurrencyConversionBean.class,from,to);
//        currencyConversionBean.setQuantity(qty);
//        currencyConversionBean.setTotalAmount(qty*currencyConversionBean.getRate());
//        return currencyConversionBean;
//    }

    @Autowired
    private CurrencyExchangeProxy proxy;

    @GetMapping("/exchangeAmount/from/{from}/to/{to}/qty/{qty}")
    public CurrencyConversionBean getConvertedAmount(@PathVariable("from")String from,
                                                     @PathVariable("to")String to,
                                                     @PathVariable("qty")double qty){

        CurrencyConversionBean currencyConversionBean = proxy.retrieveExchangeRate(from, to);
        currencyConversionBean.setQuantity(qty);
        currencyConversionBean.setTotalAmount(qty*currencyConversionBean.getRate());
        return currencyConversionBean;
    }

}
