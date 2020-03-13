package com.homehub.ms.repository;

import com.homehub.ms.entities.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    @Query(value = "SELECT pm.customerVendor.customerVendorId FROM  PaymentMethod pm" +
            " WHERE pm.id = :id")
    public String getCustomerVendorStringFromPaymentMethodId(@Param("id") long id);

}
