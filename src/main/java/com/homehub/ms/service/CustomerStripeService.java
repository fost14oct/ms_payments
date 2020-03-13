package com.homehub.ms.service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.homehub.ms.dto.CreateCustomerResponseDTO;
import com.homehub.ms.dto.CustomerStripeDTO;
import com.homehub.ms.entities.Customer;
import com.homehub.ms.entities.CustomerVendor;
import com.homehub.ms.entities.Vendor;
import com.homehub.ms.repository.CustomerRepository;
import com.homehub.ms.repository.CustomerVendorRepository;
import com.homehub.ms.repository.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Optional;

@Service
@Slf4j
public class CustomerStripeService implements CustomerInterface {
    @Autowired
    CustomerVendorRepository customerVendorRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RequestsInterface customerRequests;


    @Autowired
    Vendor vendor;



    @Override
    public CreateCustomerResponseDTO createClientWithExternalID(String externalId) {
        log.info(externalId);
        CustomerStripeDTO customerStripeDTO = null;
        CustomerVendor customer = customerVendorRepository.findCustomerVendorByCustomerExternalId(externalId);
        log.info("Exist customer with externalID {}", customer);
        if (customer == null) {
            Customer newCustomer = customerRepository.save(new Customer(externalId));
            customerStripeDTO = (CustomerStripeDTO) customerRequests.createCustomer();
            if (customerStripeDTO == null && customerStripeDTO.getId() == null) {
                throw new RuntimeException("Unable to create new user an exception happened");
            }
            customer =  customerVendorRepository.save(new CustomerVendor(newCustomer,vendor, customerStripeDTO.getId()));
        }
        log.info("Returning stripe customer {}",customer);
        return   new CreateCustomerResponseDTO(customer.getId());
    }
}
