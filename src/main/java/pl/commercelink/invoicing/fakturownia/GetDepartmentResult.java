package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class GetDepartmentResult {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortcut")
    private String shortcut;

    @JsonProperty("tax_no")
    private String taxNo;

    @JsonProperty("street")
    private String street;

    @JsonProperty("post_code")
    private String postCode;

    @JsonProperty("city")
    private String city;

    @JsonProperty("country")
    private String country;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("person")
    private String person;

    long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getShortcut() {
        return shortcut;
    }

    String getTaxNo() {
        return taxNo;
    }

    String getStreet() {
        return street;
    }

    String getPostCode() {
        return postCode;
    }

    String getCity() {
        return city;
    }

    String getCountry() {
        return country;
    }

    String getEmail() {
        return email;
    }

    String getPhone() {
        return phone;
    }

    String getPerson() {
        return person;
    }

}
