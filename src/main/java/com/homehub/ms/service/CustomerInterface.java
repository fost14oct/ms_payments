package com.homehub.ms.service;

import com.homehub.ms.dto.CustomerStripeDTO;

public interface CustomerInterface {
    Object createClientWithExternalID(String externalId);
}
