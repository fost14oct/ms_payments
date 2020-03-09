package com.homehub.ms.service;

import com.homehub.ms.dto.CreatePaymentMethodRequestDTO;
import com.homehub.ms.dto.CreatePaymentMethodResponseDTO;

public interface  CreatePaymentMethodInterface {
    CreatePaymentMethodResponseDTO createPaymentMethod(CreatePaymentMethodRequestDTO createPaymentMethodReques);
}
