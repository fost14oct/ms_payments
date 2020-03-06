package com.homehub.ms.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TA_CUSTOMER_VENDOR")
@Data
/*@NamedQueries({
        @NamedQuery(name = "CustomerVendor.findByCustomerExternalId",query = "Select cv From CustomerVendor cv, Customer cm where cm.externalId = :externalId "),
})*/
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

    private String customerVendorId;
}
