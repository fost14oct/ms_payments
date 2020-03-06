package com.homehub.ms.repository;

import com.homehub.ms.entities.CustomerVendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerVendorRepository extends JpaRepository<CustomerVendor,Long> {
    CustomerVendor findCustomerVendorByCustomerExternalId(String externalId);
}
