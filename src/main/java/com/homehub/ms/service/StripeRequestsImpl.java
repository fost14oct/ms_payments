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
public class StripeRequestsImpl implements RequestsInterface{
    @Value("${stripe.api.url}/customers")
    String apiCustomerUrl;

    @Value("${stripe.api.url}/payment_methods")
    String apiPaymentMethodsUrl;

    @Value("${stripe.api.url}/payment_intents")
    String apiPaymentIntentUrl;

    @Value("${stripe.api.secret}")
    String apiSecret;

    @Autowired
    RestTemplate restTemplate;


    HttpHeaders headers;


    @PostConstruct
    public void init() {
        headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + apiSecret);
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));
    }


    @Override
    public CustomerStripeDTO createCustomer(Object... o) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<CustomerStripeDTO> response = restTemplate.exchange(apiCustomerUrl, HttpMethod.POST, entity, CustomerStripeDTO.class);
        log.info("Response DTO {}", response.getBody());
        return response.getBody();
    }

    @Override
    public CustomerStripeDTO getCustomerById(String id) {
        log.info("Get customer with ID {}",id);
        String retrieveCustomerURL = apiCustomerUrl + "/" + id ;
        log.info("Retrieve customer url {}",retrieveCustomerURL);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<CustomerStripeDTO> response = restTemplate.exchange(retrieveCustomerURL, HttpMethod.GET, entity, CustomerStripeDTO.class);
        return response.getBody();
    }

    @Override
    public Object createCustomerPaymentMethodByCard(MultiValueMap<String, Object> cardParams) {
        String createPaymentMethodUrl = apiPaymentMethodsUrl;
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(cardParams, headers);
        ResponseEntity<PaymentMethodDTO> responseEntity = restTemplate.exchange(createPaymentMethodUrl, HttpMethod.POST, entity, PaymentMethodDTO.class);
        return responseEntity.getBody();
    }

    @Override
    public void attachPaymentMethodToCustomer(String paymentMethodId, String customerId) {
        log.info("Attach payment method with customer id {} and payment method id {}",customerId,paymentMethodId);
        String attachPaymentMethodURL = apiPaymentMethodsUrl +"/" + paymentMethodId + "/attach";
        log.info("Attach payment method url {}",attachPaymentMethodURL);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("customer",customerId);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
        ResponseEntity<PaymentMethodDTO> response = restTemplate.exchange(attachPaymentMethodURL, HttpMethod.POST, entity, PaymentMethodDTO.class);
        log.info("HTTP STATUS {}",response.getStatusCode() );
        log.info("RESPONSE ATTACHMENT {}",response.getBody());
    }

    @Override
    public void createPaymentIntent(MultiValueMap<String, Object> paymentIntentParams) {
        log.info("Api payment intent url {}", apiPaymentIntentUrl);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(paymentIntentParams, headers);
        ResponseEntity<PaymentMethodDTO> response = restTemplate.exchange(apiPaymentIntentUrl, HttpMethod.POST, entity, PaymentMethodDTO.class);
        log.info("HTTP STATUS {}",response.getStatusCode());
        log.info("RESPONSE ATTACHMENT {}",response.getBody());

    }
}
