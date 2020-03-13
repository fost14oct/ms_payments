package com.homehub.ms.service;

import com.homehub.ms.dto.CreatePaymentIntentRequestDTO;

public interface CreatePaymentIntentInterface {

    public String createPaymentIntent(CreatePaymentIntentRequestDTO createPaymentIntentRequest);
}
