package com.synycs.paymentgateway;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "payment_gateway")
public class PaymentGatewayBean{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name= "card_number")
    private long cardNumber;

    @Column(name= "card_holder_name")
    private String cardHolderName;

    @Column(name= "status")
    private boolean status;

    @Column(name = "amount")
    private int amount;

    @Transient
    private int port;

    public PaymentGatewayBean(){}


    public PaymentGatewayBean(long cardNumber, String cardHolderName, boolean status, int amount) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.status = status;
        this.amount = amount;
    }
}
