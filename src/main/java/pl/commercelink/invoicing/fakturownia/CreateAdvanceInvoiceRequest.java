package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.commercelink.invoicing.api.InvoiceKind;

class CreateAdvanceInvoiceRequest {

    @JsonProperty("oid")
    private String oid;

    @JsonProperty("copy_invoice_from")
    private long copyInvoiceFrom;

    @JsonProperty("kind")
    private String kind = FakturowniaApiMapper.toApiInvoiceKind(InvoiceKind.Advance);

    @JsonProperty("advance_creation_mode")
    private String advanceCreationMode = "amount";

    @JsonProperty("advance_value")
    private double advanceValue;

    @JsonProperty("sell_date")
    private String sellDate;

    @JsonProperty("sell_date_kind")
    private String sellDateKind = "ADVANCE_RECEIPT_DATE";

    @JsonProperty("split_payment")
    private String splitPayment;

    @JsonProperty("paid")
    private double paid;

    CreateAdvanceInvoiceRequest(String orderId, long wmsOrderId, double advanceValue, String sellDate, boolean splitPayment) {
        this.oid = orderId;
        this.copyInvoiceFrom = wmsOrderId;
        this.advanceValue = advanceValue;
        this.paid = advanceValue;
        this.sellDate = sellDate;
        this.splitPayment = splitPayment ? "1" : "0";
    }
}
