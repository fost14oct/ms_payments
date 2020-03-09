package com.homehub.ms.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TC_VENDOR")
@Data
public class Vendor {


    public Vendor(){}
    public Vendor(String vendorName){
        this.name = vendorName;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    private String name;
    @ToString.Exclude
    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    private List<CustomerVendor> customerVendor;

}
