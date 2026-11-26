package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class GetInvoiceResult {

    static final List<String> VAT_EU_COUNTRIES = new LinkedList<>();

    static {
        VAT_EU_COUNTRIES.add("AT");
        VAT_EU_COUNTRIES.add("BE");
        VAT_EU_COUNTRIES.add("BG");
        VAT_EU_COUNTRIES.add("CY");
        VAT_EU_COUNTRIES.add("CZ");
        VAT_EU_COUNTRIES.add("DE");
        VAT_EU_COUNTRIES.add("DK");
        VAT_EU_COUNTRIES.add("EE");
        VAT_EU_COUNTRIES.add("EL");
        VAT_EU_COUNTRIES.add("ES");
        VAT_EU_COUNTRIES.add("FI");
        VAT_EU_COUNTRIES.add("FR");
        VAT_EU_COUNTRIES.add("HR");
        VAT_EU_COUNTRIES.add("HU");
        VAT_EU_COUNTRIES.add("IT");
        VAT_EU_COUNTRIES.add("LT");
        VAT_EU_COUNTRIES.add("LU");
        VAT_EU_COUNTRIES.add("LV");
        VAT_EU_COUNTRIES.add("MT");
        VAT_EU_COUNTRIES.add("NL");
//        VAT_EU_COUNTRIES.add("PL");
        VAT_EU_COUNTRIES.add("PT");
        VAT_EU_COUNTRIES.add("RO");
        VAT_EU_COUNTRIES.add("SE");
        VAT_EU_COUNTRIES.add("SI");
        VAT_EU_COUNTRIES.add("SK");
    }


    @JsonProperty("id")
    private long id;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("app")
    private String app;

    @JsonProperty("number")
    private String number;

    @JsonProperty("place")
    private String place;

    @JsonProperty("sell_date")
    private String sellDate;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("price_net")
    private double priceNet;

    @JsonProperty("price_gross")
    private double priceGross;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("status")
    private String status;

    @JsonProperty("description")
    private String description;

    @JsonProperty("seller_name")
    private String sellerName;

    @JsonProperty("seller_tax_no")
    private String sellerTaxNo;

    @JsonProperty("seller_street")
    private String sellerStreet;

    @JsonProperty("seller_post_code")
    private String sellerPostCode;

    @JsonProperty("seller_city")
    private String sellerCity;

    @JsonProperty("seller_country")
    private String sellerCountry;

    @JsonProperty("seller_email")
    private String sellerEmail;

    @JsonProperty("seller_phone")
    private String sellerPhone;

    @JsonProperty("seller_fax")
    private String sellerFax;

    @JsonProperty("seller_www")
    private String sellerWww;

    @JsonProperty("seller_person")
    private String sellerPerson;

    @JsonProperty("seller_bank")
    private String sellerBank;

    @JsonProperty("seller_bank_account")
    private String sellerBankAccount;

    @JsonProperty("buyer_name")
    private String buyerName;

    @JsonProperty("buyer_tax_no")
    private String buyerTaxNo;

    @JsonProperty("buyer_post_code")
    private String buyerPostCode;

    @JsonProperty("buyer_city")
    private String buyerCity;

    @JsonProperty("buyer_street")
    private String buyerStreet;

    @JsonProperty("buyer_first_name")
    private String buyerFirstName;

    @JsonProperty("buyer_country")
    private String buyerCountry;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("token")
    private String token;

    @JsonProperty("buyer_email")
    private String buyerEmail;

    @JsonProperty("buyer_www")
    private String buyerWww;

    @JsonProperty("buyer_fax")
    private String buyerFax;

    @JsonProperty("buyer_phone")
    private String buyerPhone;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("pattern")
    private String pattern;

    @JsonProperty("pattern_nr")
    private Integer patternNr;

    @JsonProperty("pattern_nr_m")
    private Integer patternNrM;

    @JsonProperty("pattern_nr_d")
    private Integer patternNrD;

    @JsonProperty("client_id")
    private long clientId;

    @JsonProperty("payment_to")
    private String paymentTo;

    @JsonProperty("paid")
    private double paid;

    @JsonProperty("seller_bank_account_id")
    private String sellerBankAccountId;

    @JsonProperty("lang")
    private String lang;

    @JsonProperty("issue_date")
    private String issueDate;

    @JsonProperty("price_tax")
    private String priceTax;

    @JsonProperty("department_id")
    private long departmentId;

    @JsonProperty("correction")
    private String correction;

    @JsonProperty("buyer_note")
    private String buyerNote;

    @JsonProperty("additional_info_desc")
    private String additionalInfoDesc;

    @JsonProperty("additional_info")
    private boolean additionalInfo;

    @JsonProperty("product_cache")
    private String productCache;

    @JsonProperty("buyer_last_name")
    private String buyerLastName;

    @JsonProperty("from_invoice_id")
    private String fromInvoiceId;

    @JsonProperty("oid")
    private String oid;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("show_discount")
    private boolean showDiscount;

    @JsonProperty("sent_time")
    private String sentTime;

    @JsonProperty("print_time")
    private String printTime;

    @JsonProperty("recurring_id")
    private String recurringId;

    @JsonProperty("tax2_visible")
    private String tax2Visible;

    @JsonProperty("warehouse_id")
    private String warehouseId;

    @JsonProperty("paid_date")
    private String paidDate;

    @JsonProperty("product_id")
    private long productId;

    @JsonProperty("issue_year")
    private int issueYear;

    @JsonProperty("internal_note")
    private String internalNote;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("invoice_template_id")
    private int invoiceTemplateId;

    @JsonProperty("description_long")
    private String descriptionLong;

    @JsonProperty("buyer_tax_no_kind")
    private String buyerTaxNoKind;

    @JsonProperty("seller_tax_no_kind")
    private String sellerTaxNoKind;

    @JsonProperty("description_footer")
    private String descriptionFooter;

    @JsonProperty("sell_date_kind")
    private String sellDateKind;

    @JsonProperty("payment_to_kind")
    private String paymentToKind;

    @JsonProperty("exchange_currency")
    private String exchangeCurrency;

    @JsonProperty("discount_kind")
    private String discountKind;

    @JsonProperty("income")
    private boolean income;

    @JsonProperty("from_api")
    private boolean fromApi;

    @JsonProperty("category_id")
    private String categoryId;

    @JsonProperty("warehouse_document_id")
    private String warehouseDocumentId;

    @JsonProperty("exchange_kind")
    private String exchangeKind;

    @JsonProperty("exchange_rate")
    private double exchangeRate;

    @JsonProperty("use_delivery_address")
    private boolean useDeliveryAddress;

    @JsonProperty("delivery_address")
    private String deliveryAddress;

    @JsonProperty("accounting_kind")
    private String accountingKind;

    @JsonProperty("buyer_person")
    private String buyerPerson;

    @JsonProperty("buyer_bank_account")
    private String buyerBankAccount;

    @JsonProperty("buyer_bank")
    private String buyerBank;

    @JsonProperty("buyer_mass_payment_code")
    private String buyerMassPaymentCode;

    @JsonProperty("exchange_note")
    private String exchangeNote;

    @JsonProperty("buyer_company")
    private boolean buyerCompany;

    @JsonProperty("show_attachments")
    private boolean showAttachments;

    @JsonProperty("exchange_currency_rate")
    private String exchangeCurrencyRate;

    @JsonProperty("has_attachments")
    private boolean hasAttachments;

    @JsonProperty("exchange_date")
    private String exchangeDate;

    @JsonProperty("attachments_count")
    private int attachmentsCount;

    @JsonProperty("delivery_date")
    private String deliveryDate;

    @JsonProperty("fiscal_status")
    private String fiscalStatus;

    @JsonProperty("use_moss")
    private boolean useMoss;

    @JsonProperty("transaction_date")
    private String transactionDate;

    @JsonProperty("email_status")
    private String emailStatus;

    @JsonProperty("exclude_from_stock_level")
    private boolean excludeFromStockLevel;

    @JsonProperty("exclude_from_accounting")
    private boolean excludeFromAccounting;

    @JsonProperty("exchange_rate_den")
    private String exchangeRateDen;

    @JsonProperty("exchange_currency_rate_den")
    private String exchangeCurrencyRateDen;

    @JsonProperty("accounting_scheme")
    private String accountingScheme;

    @JsonProperty("exchange_difference")
    private String exchangeDifference;

    @JsonProperty("not_cost")
    private boolean notCost;

    @JsonProperty("reverse_charge")
    private boolean reverseCharge;

    @JsonProperty("issuer")
    private String issuer;

    @JsonProperty("use_issuer")
    private boolean useIssuer;

    @JsonProperty("cancelled")
    private boolean cancelled;

    @JsonProperty("recipient_id")
    private String recipientId;

    @JsonProperty("recipient_name")
    private String recipientName;

    @JsonProperty("test")
    private boolean test;

    @JsonProperty("discount_net")
    private String discountNet;

    @JsonProperty("approval_status")
    private String approvalStatus;

    @JsonProperty("accounting_vat_tax_date")
    private String accountingVatTaxDate;

    @JsonProperty("accounting_income_tax_date")
    private String accountingIncomeTaxDate;

    @JsonProperty("accounting_other_tax_date")
    private String accountingOtherTaxDate;

    @JsonProperty("accounting_status")
    private String accountingStatus;

    @JsonProperty("normalized_number")
    private String normalizedNumber;

    @JsonProperty("na_tax_kind")
    private String naTaxKind;

    @JsonProperty("issued_to_receipt")
    private boolean issuedToReceipt;

    @JsonProperty("gov_id")
    private String govId;

    @JsonProperty("gov_kind")
    private String govKind;

    @JsonProperty("gov_status")
    private String govStatus;

    @JsonProperty("sales_code")
    private String salesCode;

    @JsonProperty("additional_invoice_field")
    private String additionalInvoiceField;

    @JsonProperty("products_margin")
    private String productsMargin;

    @JsonProperty("payment_url")
    private String paymentUrl;

    @JsonProperty("view_url")
    private String viewUrl;

    @JsonProperty("buyer_mobile_phone")
    private String buyerMobilePhone;

    @JsonProperty("kind_text")
    private String kindText;

    @JsonProperty("invoice_for_receipt_id")
    private String invoiceForReceiptId;

    @JsonProperty("receipt_for_invoice_id")
    private String receiptForInvoiceId;

    @JsonProperty("overdue?")
    private boolean overdue;

    @JsonProperty("get_tax_name")
    private String getTaxName;

    @JsonProperty("tax_visible?")
    private boolean taxVisible;

    @JsonProperty("tax_name_type")
    private String taxNameType;

    @JsonProperty("use_oss")
    private boolean useOss;

    @JsonProperty("adjust_invoice_price")
    private String adjustInvoicePrice;

    @JsonProperty("seller_bdo_no")
    private String sellerBdoNo;

    @JsonProperty("split_payment")
    private String splitPayment;

    @JsonProperty("positions")
    private List<GetInvoicePositionResult> positions;

    long getId() {
        return id;
    }

    String getNumber() {
        return number;
    }

    String getSellDate() {
        return sellDate;
    }

    String getIssueDate() {
        return issueDate;
    }

    String getPaymentTo() {
        return paymentTo;
    }

    double getPriceNet() {
        return priceNet;
    }

    double getPriceNetInPLN() {
        return Math.round(priceNet * exchangeRate * 100.0) / 100.0;
    }

    double getPriceGross() {
        return priceGross;
    }

    double getPriceGrossInPLN() {
        return Math.round(priceGross * exchangeRate * 100.0) / 100.0;
    }

    double getPaid() {
        return paid;
    }

    String getPaymentType() {
        return paymentType;
    }

    String getCurrency() {
        return currency;
    }

    String getStatus() {
        return status;
    }

    String getApprovalStatus() {
        return approvalStatus;
    }

    String getOid() {
        return oid;
    }

    String getViewUrl() {
        return viewUrl;
    }

    String getBuyerCountry() {
        if (buyerCountry == null || buyerCountry.isBlank()) {
            return "PL";
        }
        return buyerCountry;
    }

    String getBuyerName() {
        return buyerName;
    }

    String getBuyerTaxNo() {
        return buyerTaxNo;
    }

    String getBuyerStreet() {
        return buyerStreet;
    }

    String getBuyerPostCode() {
        return buyerPostCode;
    }

    String getBuyerCity() {
        return buyerCity;
    }

    String getExchangeCurrency() {
        return exchangeCurrency;
    }

    double getExchangeRate() {
        return exchangeRate;
    }

    long getClientId() {
        return clientId;
    }

    List<GetInvoicePositionResult> getPositions() {
        return positions;
    }

    String getSellerName() {
        return sellerName;
    }

    String getSellerTaxNo() {
        return sellerTaxNo;
    }

    String getSellerStreet() {
        return sellerStreet;
    }

    String getSellerPostCode() {
        return sellerPostCode;
    }

    String getSellerCity() {
        return sellerCity;
    }

    String getSellerCountry() {
        return sellerCountry;
    }

}
