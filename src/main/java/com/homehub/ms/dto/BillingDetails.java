package com.homehub.ms.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"address",
"email",
"name",
"phone"
})
public class BillingDetails {

@JsonProperty("address")
private Address address;
@JsonProperty("email")
private Object email;
@JsonProperty("name")
private Object name;
@JsonProperty("phone")
private Object phone;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("address")
public Address getAddress() {
return address;
}

@JsonProperty("address")
public void setAddress(Address address) {
this.address = address;
}

@JsonProperty("email")
public Object getEmail() {
return email;
}

@JsonProperty("email")
public void setEmail(Object email) {
this.email = email;
}

@JsonProperty("name")
public Object getName() {
return name;
}

@JsonProperty("name")
public void setName(Object name) {
this.name = name;
}

@JsonProperty("phone")
public Object getPhone() {
return phone;
}

@JsonProperty("phone")
public void setPhone(Object phone) {
this.phone = phone;
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