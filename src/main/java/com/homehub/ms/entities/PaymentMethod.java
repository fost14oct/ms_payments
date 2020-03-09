package com.homehub.ms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TA_PAYMENT_METHOD")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    public PaymentMethod(CustomerVendor customerVendor,String vendorPaymentMethodId){
        this.customerVendor = customerVendor;
        this.vendorPaymentMethodId = vendorPaymentMethodId;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_vendor_id")
    private CustomerVendor customerVendor;

    private String vendorPaymentMethodId;
}
