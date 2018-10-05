package com.synycs.paymentgateway;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentGatewayController {
    @Autowired
    private PaymentGatewayRepository paymentGatewayRepository;

    @Autowired
    private Environment environment;


//    @GetMapping("/payment/{cardNumber}/{cardHolderName}")
//    public PaymentGatewayBean getPayment(@PathVariable("cardNumber")long cardNumber,
//                                         @PathVariable("cardHolderName")String cardHolderName) {
//        val result= (List<PaymentGatewayBean>)paymentGatewayRepository.findAll();
//        //findByCardHolderNameAndCardNumber(cardHolderName,cardNumber)
//        val filerResult=result.stream().filter(x->(x.getCardHolderName().
//                equals(cardHolderName) && x.getCardNumber()==cardNumber)).findAny();
//
//        PaymentGatewayBean paymentGatewayBean=new PaymentGatewayBean();
//        if(filerResult.isPresent()){
//
//            paymentGatewayBean=filerResult.get();
//            paymentGatewayBean.setPort(Integer.parseInt(environment.getProperty("server.port")));
//
//            return paymentGatewayBean;
//        }
//        return paymentGatewayBean;
//    }

    @GetMapping("/payment/{cardNumber}/{cardHolderName}/{amount}")
    public PaymentGatewayBean getPayment(@PathVariable("cardNumber")long cardNumber,
                                         @PathVariable("cardHolderName")String cardHolderName,
                                         @PathVariable("amount")int amount) {

        PaymentGatewayBean paymentGatewayBean=new PaymentGatewayBean();

        val result=paymentGatewayRepository.findByCardHolderNameAndCardNumber(cardHolderName,cardNumber);
        if(result.isPresent()){

            paymentGatewayBean=result.get();
            if(amount<=paymentGatewayBean.getAmount()){
                paymentGatewayBean.setStatus(true);
            }
            paymentGatewayBean.setPort(Integer.parseInt(environment.getProperty("server.port")));

            return paymentGatewayBean;
        }
        return paymentGatewayBean;
    }


}
