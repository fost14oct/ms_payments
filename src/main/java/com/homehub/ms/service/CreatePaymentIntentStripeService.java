package com.homehub.ms.service;

import com.homehub.ms.dto.CreatePaymentIntentRequestDTO;
import com.homehub.ms.entities.PaymentMethod;
import com.homehub.ms.exception.BussinesException;
import com.homehub.ms.repository.PaymentMethodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

@Service
@Slf4j
public class CreatePaymentIntentStripeService implements CreatePaymentIntentInterface {

    @Autowired
    RequestsInterface stripeRequest;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public String createPaymentIntent(CreatePaymentIntentRequestDTO createPaymentIntentRequest) {
        if (!isValidRequest(createPaymentIntentRequest)) {
            throw new RuntimeException("Invalid Request");
        }
        log.info("Create payment intent request {}",createPaymentIntentRequest);
        Optional<PaymentMethod> paymentMethod = paymentMethodRepository.findById(createPaymentIntentRequest.getPaymentMethodId());
        paymentMethod.orElseThrow(BussinesException::new);
        MultiValueMap<String, Object> cardParams = new LinkedMultiValueMap<>();
        cardParams.add("customer", paymentMethod.get().getCustomerVendor().getCustomerVendorId());
        cardParams.add("payment_method", paymentMethod.get().getVendorPaymentMethodId());
        cardParams.add("amount", createPaymentIntentRequest.getAmount());
        cardParams.add("confirm", "true");
        cardParams.add("currency", createPaymentIntentRequest.getCurrency());
        stripeRequest.createPaymentIntent(cardParams);
        return "Success";
    }


    private boolean isValidRequest(CreatePaymentIntentRequestDTO createPaymentIntentRequest) {
        return createPaymentIntentRequest != null && createPaymentIntentRequest.getAmount() != null && createPaymentIntentRequest.getPaymentMethodId() != null
                && createPaymentIntentRequest.getCurrency() != null;
    }
}
