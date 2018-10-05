package com.synycs.paymentgatewayclient;

import lombok.Data;

@Data
public class PaymentGatewayBean {
    private int id;
    private String cardHolderName;
    private long cardNumber;
    private boolean status;
    private int amount;
    private int billingAmount;
    private String message;

}
