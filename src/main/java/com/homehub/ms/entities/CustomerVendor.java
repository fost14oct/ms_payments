package com.homehub.ms.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TA_CUSTOMER_VENDOR")
@Data
public class CustomerVendor {

    public CustomerVendor(){}


    public CustomerVendor(Customer customer,Vendor vendor,String customerVendorId){
        this.customerVendorId = customerVendorId;
        this.customer = customer;
        this.vendor = vendor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @ToString.Exclude
    @OneToMany(mappedBy = "customerVendor", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    private List<PaymentMethod> paymentMethod;

    private String customerVendorId;
}
