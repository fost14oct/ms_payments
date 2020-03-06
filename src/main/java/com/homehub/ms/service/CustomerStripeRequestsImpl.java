package com.homehub.ms.service;

import com.homehub.ms.dto.CustomerStripeDTO;
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
public class CustomerStripeRequestsImpl implements CustomerRequestsInterface {
    @Value("${stripe.api.url}/customers ")
    private String apiUrl;


    @Value("${stripe.api.secret}")
    private String apiSecret;

    @Autowired
    private RestTemplate restTemplate;


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
        ResponseEntity<CustomerStripeDTO> response = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, CustomerStripeDTO.class);
        log.info("Response DTO {}", response.getBody());
        return response.getBody();
    }

    @Override
    public CustomerStripeDTO getCustomerById(String id) {
        log.info("Get customer with ID {}",id);
        String retrieveCustomerURL = apiUrl.concat("/" + id);
        log.info("Retrieve customer url {}",retrieveCustomerURL);
        HttpEntity<String> entity = new HttpEntity<>("", headers);
        ResponseEntity<CustomerStripeDTO> response = restTemplate.exchange(retrieveCustomerURL, HttpMethod.GET, entity, CustomerStripeDTO.class);
        return response.getBody();
    }
}
