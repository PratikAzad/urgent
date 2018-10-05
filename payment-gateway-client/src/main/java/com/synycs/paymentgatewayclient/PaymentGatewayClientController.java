package com.synycs.paymentgatewayclient;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentGatewayClientController {


    /*@GetMapping("makePayment/{card}/{name}/{billingAmount}")
    public PaymentGatewayBean getPaymentStatus(@PathVariable("card")long card,
                                               @PathVariable("name")String name,
                                               @PathVariable("billingAmount")int billingAmount){

        PaymentGatewayBean paymentGatewayBean=new RestTemplate().getForObject(
                "http://localhost:8019/payment/{cardNumber}/{cardHolderName}/{amount}",
                PaymentGatewayBean.class,card,name,billingAmount);

        if(paymentGatewayBean.isStatus()){
            paymentGatewayBean.setMessage("Payment Successful");
        }
        else {
            paymentGatewayBean.setMessage("Payment Failed");
        }
        return paymentGatewayBean;
    }*/

    @Autowired
    private PaymentGatewayProxy proxy;

    @GetMapping("makePayment/{card}/{name}/{billingAmount}")
    public PaymentGatewayBean makePayment(@PathVariable("card")long card,
                                               @PathVariable("name")String name,
                                               @PathVariable("billingAmount")int billingAmount){
        val paymentGatewayBean=proxy.makePayment(card,name ,billingAmount );
        if(paymentGatewayBean.isStatus()){
            paymentGatewayBean.setMessage("Payment Successful");
        }
        else {
            paymentGatewayBean.setMessage("Payment Failed");
        }
        return paymentGatewayBean;
    }



    @GetMapping("/test")
    public String test(){
        return "Its Working";
    }
}
