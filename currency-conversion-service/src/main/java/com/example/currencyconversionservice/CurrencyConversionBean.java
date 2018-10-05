package com.example.currencyconversionservice;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversionBean {

    private int id;
    private String currencyFrom;
    private String currencyTo;
    private double rate;
    private double quantity;
    private double totalAmount;
    private int port;
}
