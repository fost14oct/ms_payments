package com.homehub.ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreatePaymentMethodRequestDTO {
    private Long customerVendorId;
    private Long cardCVC;
    private Long cardNumber;
    private Long expMonth;
    private Long expYear;
}
