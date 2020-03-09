package com.homehub.ms.config;

import com.homehub.ms.entities.Vendor;
import com.homehub.ms.repository.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Configuration
@Slf4j
public class BeanConfig {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public Vendor vendor(VendorRepository vendorRepository){
        log.info("Looking vendor");
        Vendor vendor = vendorRepository.findByName("Stripe");
        log.info("Vendor {}",vendor);
        if(vendor == null){
            log.info("Vendor Repository {}");
            vendor = vendorRepository.save(new Vendor("Stripe"));
        }
        log.info("Vendor {}",vendor);
        return vendor;
    }
}
