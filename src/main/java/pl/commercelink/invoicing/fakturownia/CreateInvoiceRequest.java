package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

class CreateInvoiceRequest {

    @JsonProperty("number")
    private String number;

    @JsonProperty("oid")
    private String oid;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("sell_date")
    private String sellDate;

    @JsonProperty("issue_date")
    private String issueDate;

    @JsonProperty("payment_to")
    private String paymentTo;

    @JsonProperty("split_payment")
    private String splitPayment;

    @JsonProperty("department_id")
    private String departmentId;

    @JsonProperty("seller_name")
    private String sellerName;

    @JsonProperty("seller_tax_no")
    private String sellerTaxNo;

    @JsonProperty("buyer_company")
    private String buyerCompany;

    @JsonProperty("buyer_name")
    private String buyerName;

    @JsonProperty("buyer_person")
    private String buyerPerson;

    @JsonProperty("buyer_first_name")
    private String buyerFirstName;

    @JsonProperty("buyer_last_name")
    private String buyerLastName;

    @JsonProperty("buyer_tax_no")
    private String buyerTaxNo;

    @JsonProperty("buyer_tax_no_kind")
    private String buyerTaxNoKind;

    @JsonProperty("buyer_street")
    private String buyerStreet;

    @JsonProperty("buyer_post_code")
    private String buyerPostCode;

    @JsonProperty("buyer_city")
    private String buyerCity;

    @JsonProperty("buyer_country")
    private String buyerCountry;

    @JsonProperty("buyer_email")
    private String buyerEmail;

    @JsonProperty("description")
    private String description;

    @JsonProperty("paid")
    private double paid;

    @JsonProperty("positions")
    private List<CreateInvoicePositionRequest> positions;

    void setNumber(String number) {
        this.number = number;
    }

    void setOid(String oid) {
        this.oid = oid;
    }

    void setCurrency(String currency) {
        this.currency = currency;
    }

    void setLang(String lang) {
        this.lang = lang;
    }

    void setKind(String kind) {
        this.kind = kind;
    }

    void setSellDate(String sellDate) {
        this.sellDate = sellDate;
    }

    void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    void setPaymentTo(String paymentTo) {
        this.paymentTo = paymentTo;
    }

    void setSplitPayment(String splitPayment) {
        this.splitPayment = splitPayment;
    }

    void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    void setSellerTaxNo(String sellerTaxNo) {
        this.sellerTaxNo = sellerTaxNo;
    }

    void setBuyerCompany(String buyerCompany) {
        this.buyerCompany = buyerCompany;
    }

    void setBuyerPerson(String buyerPerson) {
        this.buyerPerson = buyerPerson;
    }

    void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    void setBuyerTaxNo(String buyerTaxNo) {
        this.buyerTaxNo = buyerTaxNo;
    }

    void setBuyerTaxNoKind(String buyerTaxNoKind) {
        this.buyerTaxNoKind = buyerTaxNoKind;
    }

    void setBuyerStreet(String buyerStreet) {
        this.buyerStreet = buyerStreet;
    }

    void setBuyerPostCode(String buyerPostCode) {
        this.buyerPostCode = buyerPostCode;
    }

    void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }

    void setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
    }

    void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }

    void setDescription(String description) {
        this.description = description;
    }

    void setPaid(double paid) {
        this.paid = paid;
    }

    void setPositions(List<CreateInvoicePositionRequest> positions) {
        this.positions = positions;
    }
}
