package com.synycs.paymentgateway;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface PaymentGatewayRepository extends CrudRepository<PaymentGatewayBean,Integer> {

    Optional<PaymentGatewayBean> findByCardHolderNameAndCardNumber(String cardHolderName, long cardNumber);

}
