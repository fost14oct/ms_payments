package com.homehub.ms.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"object",
"billing_details",
"card",
"created",
"customer",
"livemode",
"metadata",
"type"
})
@ToString
public class PaymentMethodDTO {

@JsonProperty("id")
private String id;
@JsonProperty("object")
private String object;
@JsonProperty("billing_details")
private BillingDetails billingDetails;
@JsonProperty("card")
private Card card;
@JsonProperty("created")
private Integer created;
@JsonProperty("customer")
private Object customer;
@JsonProperty("livemode")
private Boolean livemode;
@JsonProperty("metadata")
private Metadata metadata;
@JsonProperty("type")
private String type;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("object")
public String getObject() {
return object;
}

@JsonProperty("object")
public void setObject(String object) {
this.object = object;
}

@JsonProperty("billing_details")
public BillingDetails getBillingDetails() {
return billingDetails;
}

@JsonProperty("billing_details")
public void setBillingDetails(BillingDetails billingDetails) {
this.billingDetails = billingDetails;
}

@JsonProperty("card")
public Card getCard() {
return card;
}

@JsonProperty("card")
public void setCard(Card card) {
this.card = card;
}

@JsonProperty("created")
public Integer getCreated() {
return created;
}

@JsonProperty("created")
public void setCreated(Integer created) {
this.created = created;
}

@JsonProperty("customer")
public Object getCustomer() {
return customer;
}

@JsonProperty("customer")
public void setCustomer(Object customer) {
this.customer = customer;
}

@JsonProperty("livemode")
public Boolean getLivemode() {
return livemode;
}

@JsonProperty("livemode")
public void setLivemode(Boolean livemode) {
this.livemode = livemode;
}

@JsonProperty("metadata")
public Metadata getMetadata() {
return metadata;
}

@JsonProperty("metadata")
public void setMetadata(Metadata metadata) {
this.metadata = metadata;
}

@JsonProperty("type")
public String getType() {
return type;
}

@JsonProperty("type")
public void setType(String type) {
this.type = type;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}