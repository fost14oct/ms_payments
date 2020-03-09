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
"brand",
"checks",
"country",
"exp_month",
"exp_year",
"fingerprint",
"funding",
"generated_from",
"last4",
"three_d_secure_usage",
"wallet"
})
public class Card {

@JsonProperty("brand")
private String brand;
@JsonProperty("checks")
private Checks checks;
@JsonProperty("country")
private String country;
@JsonProperty("exp_month")
private Integer expMonth;
@JsonProperty("exp_year")
private Integer expYear;
@JsonProperty("fingerprint")
private String fingerprint;
@JsonProperty("funding")
private String funding;
@JsonProperty("generated_from")
private Object generatedFrom;
@JsonProperty("last4")
private String last4;
@JsonProperty("three_d_secure_usage")
private ThreeDSecureUsage threeDSecureUsage;
@JsonProperty("wallet")
private Object wallet;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("brand")
public String getBrand() {
return brand;
}

@JsonProperty("brand")
public void setBrand(String brand) {
this.brand = brand;
}

@JsonProperty("checks")
public Checks getChecks() {
return checks;
}

@JsonProperty("checks")
public void setChecks(Checks checks) {
this.checks = checks;
}

@JsonProperty("country")
public String getCountry() {
return country;
}

@JsonProperty("country")
public void setCountry(String country) {
this.country = country;
}

@JsonProperty("exp_month")
public Integer getExpMonth() {
return expMonth;
}

@JsonProperty("exp_month")
public void setExpMonth(Integer expMonth) {
this.expMonth = expMonth;
}

@JsonProperty("exp_year")
public Integer getExpYear() {
return expYear;
}

@JsonProperty("exp_year")
public void setExpYear(Integer expYear) {
this.expYear = expYear;
}

@JsonProperty("fingerprint")
public String getFingerprint() {
return fingerprint;
}

@JsonProperty("fingerprint")
public void setFingerprint(String fingerprint) {
this.fingerprint = fingerprint;
}

@JsonProperty("funding")
public String getFunding() {
return funding;
}

@JsonProperty("funding")
public void setFunding(String funding) {
this.funding = funding;
}

@JsonProperty("generated_from")
public Object getGeneratedFrom() {
return generatedFrom;
}

@JsonProperty("generated_from")
public void setGeneratedFrom(Object generatedFrom) {
this.generatedFrom = generatedFrom;
}

@JsonProperty("last4")
public String getLast4() {
return last4;
}

@JsonProperty("last4")
public void setLast4(String last4) {
this.last4 = last4;
}

@JsonProperty("three_d_secure_usage")
public ThreeDSecureUsage getThreeDSecureUsage() {
return threeDSecureUsage;
}

@JsonProperty("three_d_secure_usage")
public void setThreeDSecureUsage(ThreeDSecureUsage threeDSecureUsage) {
this.threeDSecureUsage = threeDSecureUsage;
}

@JsonProperty("wallet")
public Object getWallet() {
return wallet;
}

@JsonProperty("wallet")
public void setWallet(Object wallet) {
this.wallet = wallet;
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