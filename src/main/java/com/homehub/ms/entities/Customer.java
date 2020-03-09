package com.homehub.ms.entities;

import lombok.Data;

import javax.persistence.*;

import com.homehub.ms.entities.CustomerVendor;
import lombok.ToString;

@Entity
@Table(name = "TA_CUSTOMER")
@Data
public class Customer {
    public Customer(){}
    public Customer(String externalId) {
        this.externalId = externalId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String externalId;
    @ToString.Exclude
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    private CustomerVendor customerVendor;
}
