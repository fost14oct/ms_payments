package com.homehub.ms.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

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

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @Setter(AccessLevel.NONE)
    private List<CustomerVendor> customerVendor;

}
