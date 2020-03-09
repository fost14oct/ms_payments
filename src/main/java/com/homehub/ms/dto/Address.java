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
"city",
"country",
"line1",
"line2",
"postal_code",
"state"
})
public class Address {

@JsonProperty("city")
private Object city;
@JsonProperty("country")
private Object country;
@JsonProperty("line1")
private Object line1;
@JsonProperty("line2")
private Object line2;
@JsonProperty("postal_code")
private Object postalCode;
@JsonProperty("state")
private Object state;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("city")
public Object getCity() {
return city;
}

@JsonProperty("city")
public void setCity(Object city) {
this.city = city;
}

@JsonProperty("country")
public Object getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(Object country) {
this.country = country;
}

@JsonProperty("line1")
public Object getLine1() {
return line1;
}

@JsonProperty("line1")
public void setLine1(Object line1) {
this.line1 = line1;
}

@JsonProperty("line2")
public Object getLine2() {
return line2;
}

@JsonProperty("line2")
public void setLine2(Object line2) {
this.line2 = line2;
}

@JsonProperty("postal_code")
public Object getPostalCode() {
return postalCode;
}

@JsonProperty("postal_code")
public void setPostalCode(Object postalCode) {
this.postalCode = postalCode;
}

@JsonProperty("state")
public Object getState() {
return state;
}

@JsonProperty("state")
public void setState(Object state) {
this.state = state;
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