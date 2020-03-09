package com.homehub.ms.service;

import com.homehub.ms.dto.CustomerStripeDTO;
import com.homehub.ms.dto.PaymentMethodDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Service
@Slf4j
public class StripeRequestsImpl extends Requests implements RequestsInterface{



    @Override
    public CustomerStripeDTO createCustomer(Object... o) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<CustomerStripeDTO> response = restTemplate.exchange(apiUrl + "/customers", HttpMethod.POST, entity, CustomerStripeDTO.class);
        log.info("Response DTO {}", response.getBody());
        return response.getBody();
    }

    @Override
    public CustomerStripeDTO getCustomerById(String id) {
        log.info("Get customer with ID {}",id);
        String retrieveCustomerURL = apiUrl.concat("/customers/" + id);
        log.info("Retrieve customer url {}",retrieveCustomerURL);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<CustomerStripeDTO> response = restTemplate.exchange(retrieveCustomerURL, HttpMethod.GET, entity, CustomerStripeDTO.class);
        return response.getBody();
    }

    @Override
    public Object createCustomerPaymentMethodByCard(MultiValueMap<String, Object> cardParams) {
        String createPaymentMethodUrl = apiUrl.concat("/payment_methods");
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(cardParams, headers);
        ResponseEntity<PaymentMethodDTO> responseEntity = restTemplate.exchange(createPaymentMethodUrl, HttpMethod.POST, entity, PaymentMethodDTO.class);
        return responseEntity.getBody();
    }

    @Override
    public void attachPaymentMethodToCustomer(String paymentMethodId, String customerId) {
        log.info("Attach payment method with customer id {} and payment method id {}",customerId,paymentMethodId);
        String attachPaymentMethodURL = apiUrl.concat("/payment_methods/" + paymentMethodId + "/attach");
        log.info("Attach payment method url {}",attachPaymentMethodURL);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("customer",customerId);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<PaymentMethodDTO> response = restTemplate.exchange(attachPaymentMethodURL, HttpMethod.POST, entity, PaymentMethodDTO.class);
        log.info("HTTP STATUS {}",response.getStatusCode() );
        log.info("RESPONSE ATTACHMENT {}",response.getBody());
    }
}
