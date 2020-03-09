package com.homehub.ms.service;

import com.homehub.ms.dto.CreateCustomerResponseDTO;
import com.homehub.ms.dto.CustomerStripeDTO;

public interface CustomerInterface {
    CreateCustomerResponseDTO createClientWithExternalID(String externalId);
}
