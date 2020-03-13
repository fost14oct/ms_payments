package com.homehub.ms.service;

import org.springframework.util.MultiValueMap;

public interface RequestsInterface {

    public Object createCustomer(Object ... o);
    public Object getCustomerById(String id);
    public Object createCustomerPaymentMethodByCard(MultiValueMap<String, Object> cardParams);
    public void attachPaymentMethodToCustomer(String paymentMethodId, String customerId);
    public void createPaymentIntent(MultiValueMap<String, Object> paymentIntentParams);
}
