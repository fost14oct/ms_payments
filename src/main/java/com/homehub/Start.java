package com.homehub;

import com.homehub.ms.entities.Vendor;
import com.homehub.ms.repository.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@SpringBootApplication(scanBasePackages = {"com.homehub"})
@EnableSwagger2
public class Start implements CommandLineRunner {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private VendorRepository vendorRepository;





    public static void main(String[] args) {
        SpringApplication.run(Start.class, args);
    }


    public void run(String... args) throws Exception {
        //Vendor vendor =  vendorRepository.save(new Vendor("Stripe"));
        //log.info("Vendor {}",vendor);
    }

   /*   @Override
    public void run(String... args) throws Exception {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.clear();
            headers.add("Authorization", "Bearer sk_test_1mx2OMGN2SA5wOi2FJjJojBl00Z5g0DK3i");
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_FORM_URLENCODED));
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
            map.add("customer", "cus_GqPexwnw9BNQNK");
            map.add("payment_method", "pm_1GJ1jSC2iONCqrBqJ0XakSgQ");
            map.add("amount", "1000");
            map.add("confirm", "true");
            map.add("currency", "mxn");
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);
           Map<String, String> cardMap= new HashMap<>();
            map.add("type", "card");
            map.add("card[number]","4242424242424242");
            map.add("card[exp_month]","3");
            map.add("card[exp_year]","2021");
            map.add("card[cvc]","314");
            HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(map, headers);


//            map.add("description", "My First Test Customer");
//            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
//cus_GqPexwnw9BNQNK , pm_1GJ1jSC2iONCqrBqJ0XakSgQ

            ResponseEntity<String> response = restTemplate.exchange("https://api.stripe.com/v1/payment_intents", HttpMethod.POST, entity, String.class);
            log.info(response.getBody());
            log.info("" + response.getStatusCodeValue());
            log.info("" + response.getStatusCode().toString());
        } catch (Exception e) {
            log.info(e.getMessage());
        }

    }*/
}