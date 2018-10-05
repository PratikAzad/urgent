package com.synycs.paymentgatewayclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients(basePackages = "com.synycs")
public class PaymentGatewayClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGatewayClientApplication.class, args);
	}
}
