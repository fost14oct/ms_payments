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
"address_line1_check",
"address_postal_code_check",
"cvc_check"
})
public class Checks {

@JsonProperty("address_line1_check")
private Object addressLine1Check;
@JsonProperty("address_postal_code_check")
private Object addressPostalCodeCheck;
@JsonProperty("cvc_check")
private Object cvcCheck;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("address_line1_check")
public Object getAddressLine1Check() {
return addressLine1Check;
}

@JsonProperty("address_line1_check")
public void setAddressLine1Check(Object addressLine1Check) {
this.addressLine1Check = addressLine1Check;
}

@JsonProperty("address_postal_code_check")
public Object getAddressPostalCodeCheck() {
return addressPostalCodeCheck;
}

@JsonProperty("address_postal_code_check")
public void setAddressPostalCodeCheck(Object addressPostalCodeCheck) {
this.addressPostalCodeCheck = addressPostalCodeCheck;
}

@JsonProperty("cvc_check")
public Object getCvcCheck() {
return cvcCheck;
}

@JsonProperty("cvc_check")
public void setCvcCheck(Object cvcCheck) {
this.cvcCheck = cvcCheck;
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