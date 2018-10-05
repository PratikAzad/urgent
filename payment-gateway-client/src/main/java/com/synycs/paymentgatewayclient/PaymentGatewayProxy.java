package com.synycs.paymentgatewayclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "payment-gateway-client", url = "${proxy.url}")
public interface PaymentGatewayProxy {

    @GetMapping("/payment/{cardNumber}/{cardHolderName}/{amount}")
    PaymentGatewayBean makePayment(@PathVariable("cardNumber")long cardNumber,
                                   @PathVariable("cardHolderName")String cardHolderName,
                                   @PathVariable("amount")int amount);
}
