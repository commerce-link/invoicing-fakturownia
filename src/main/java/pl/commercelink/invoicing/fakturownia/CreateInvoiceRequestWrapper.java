package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;

class CreateInvoiceRequestWrapper {

    @JsonProperty("api_token")
    private String apiToken;

    @JsonProperty("gov_save_and_send")
    private boolean govSaveAndSend;

    @JsonProperty("invoice")
    private Object invoice;

    CreateInvoiceRequestWrapper(String apiToken, boolean govSaveAndSend, Object invoice) {
        this.apiToken = apiToken;
        this.govSaveAndSend = govSaveAndSend;
        this.invoice = invoice;
    }
}
