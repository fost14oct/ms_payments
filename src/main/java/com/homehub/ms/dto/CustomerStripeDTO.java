package com.homehub.ms.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.Map;
import java.util.Optional;

@Data
@JsonSerialize
public class CustomerStripeDTO {
    private String id;
    private String object;
    private String address;
    private long balance;
    private String created;
    private long currency;
    private long defaultSource;
    private boolean delinquent;
    private String description;
    private long discount;
    private String email;
    private String invoicePrefix;
    private Map<String , Object> invoiceSettings;
    private boolean livemode;
    private Map<String , Object> metadata;
    private String name;
    private int nextInvoiceSequence;
    private String[] preferredLocales;
    private String shipping;
    private Map<String , Object> sources;
    private Map<String , Object> subscriptions;
    private String taxAttempt;
    private  Map<String , Object> taxIds;


}
