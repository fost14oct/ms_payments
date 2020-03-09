package com.homehub.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Collections;

public abstract class Requests {
     @Value("${stripe.api.url}")
     String apiUrl;


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
}
