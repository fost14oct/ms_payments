package com.homehub.ms.service;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
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
public class CustomerStripeImpl implements CustomerInterface {
    @Autowired
    CustomerVendorRepository customerVendorRepository;

    @Autowired
    VendorRepository vendorRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerRequestsInterface customerRequests;

    @Value("${stripe.vendor.id}")
    private long vendorId;

    private Optional<Vendor> vendor;


    @PostConstruct
    public void init() {
        log.info("Starting vendor with id {}" , vendorId );
        //vendorRepository.save(new Vendor("Stripe"));
        vendor = vendorRepository.findById(vendorId);
        if (!vendor.isPresent()) {
            throw new RuntimeException("Unable to start application vendor not present");
        }
    }


    @Override
    public Object createClientWithExternalID(String externalId) {
        log.info(externalId);
        CustomerStripeDTO customerStripeDTO = null;
        CustomerVendor existingCustomer = customerVendorRepository.findCustomerVendorByCustomerExternalId(externalId);
        log.info("Exist customer with externalID {}", existingCustomer);
        if (existingCustomer == null) {
            Customer newCustomer = customerRepository.save(new Customer(externalId));
            customerStripeDTO = (CustomerStripeDTO) customerRequests.createCustomer();
            if (customerStripeDTO == null && customerStripeDTO.getId() == null) {
                throw new RuntimeException("Unable to create new user an exception happened");
            }
            customerVendorRepository.save(new CustomerVendor(newCustomer,vendor.get(), customerStripeDTO.getId()));
        }else{
            log.info("Trying to retrieve existing customer {}",existingCustomer);
            customerStripeDTO =(CustomerStripeDTO) customerRequests.getCustomerById(existingCustomer.getCustomerVendorId());
        }
        log.info("Returning stripe customer {}",customerStripeDTO);
        return customerStripeDTO;
    }
}
