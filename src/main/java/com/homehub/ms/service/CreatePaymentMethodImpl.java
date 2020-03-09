package com.homehub.ms.service;

import com.homehub.ms.dto.CreatePaymentMethodRequestDTO;
import com.homehub.ms.dto.CreatePaymentMethodResponseDTO;
import com.homehub.ms.dto.PaymentMethodDTO;
import com.homehub.ms.entities.CustomerVendor;
import com.homehub.ms.entities.PaymentMethod;
import com.homehub.ms.repository.CustomerVendorRepository;
import com.homehub.ms.repository.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Optional;

@Service
public class CreatePaymentMethodImpl implements CreatePaymentMethodInterface {

    @Autowired
    RequestsInterface stripeRequests;

    @Autowired
    CustomerVendorRepository customerVendorRepository;

    @Autowired
    PaymentMethodRepository paymentMethodRepository;

    @Override
    public CreatePaymentMethodResponseDTO createPaymentMethod(CreatePaymentMethodRequestDTO createPaymentMethodRequest) {
        if (!isValidRequest(createPaymentMethodRequest)) {
            throw new RuntimeException("Invalid Request");
        }
        Optional<CustomerVendor> customerVendor = customerVendorRepository.findById(createPaymentMethodRequest.getCustomerVendorId());
        customerVendor.orElseThrow(RuntimeException::new);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("type", "card");
        map.add("card[number]", createPaymentMethodRequest.getCardNumber());
        map.add("card[exp_month]", createPaymentMethodRequest.getExpMonth());
        map.add("card[exp_year]", createPaymentMethodRequest.getExpYear());
        map.add("card[cvc]", createPaymentMethodRequest.getCardCVC());
        PaymentMethodDTO paymentMethodDTO = (PaymentMethodDTO) stripeRequests.createCustomerPaymentMethodByCard(map);
        if (paymentMethodDTO.getId() == null) {
            throw new RuntimeException("Unable to process Request");
        }
        stripeRequests.attachPaymentMethodToCustomer(paymentMethodDTO.getId(), customerVendor.get().getCustomerVendorId());
        PaymentMethod paymentMethod = paymentMethodRepository.save(new PaymentMethod(customerVendor.get(), paymentMethodDTO.getId()));
        return new CreatePaymentMethodResponseDTO(paymentMethod.getId());
    }

    private boolean isValidRequest(CreatePaymentMethodRequestDTO createPaymentMethodRequest) {
        return createPaymentMethodRequest != null && createPaymentMethodRequest.getCardCVC() != null
                && createPaymentMethodRequest.getCardNumber() != null && createPaymentMethodRequest.getExpMonth() != null
                && createPaymentMethodRequest.getCustomerVendorId() != null && createPaymentMethodRequest.getExpYear() != null;
    }
}
