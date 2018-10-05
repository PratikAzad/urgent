package com.synycs.paymentgateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbSeeder implements CommandLineRunner{


    //If we implement CommandLineRunner this class will automatically executed when
    //Spring-Boot-Application will start.

    @Autowired
    PaymentGatewayRepository repository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("run method of DbSeeder");
        PaymentGatewayBean person1Details=new PaymentGatewayBean(101l,"Rohan S",false,10000);
        PaymentGatewayBean person2Details=new PaymentGatewayBean(102l,"Sai Ram",false,10000);
        PaymentGatewayBean person3Details=new PaymentGatewayBean(103l,"Avinash Kumar",false,10000);

        this.repository.save(person1Details);
        this.repository.save(person2Details);
        this.repository.save(person3Details);
    }
}
