package com.homehub.ms.dto;


import lombok.Data;

@Data
public class CreatePaymentIntentRequestDTO {
    private Long paymentMethodId;
    private Long amount;
    private String currency;
}