package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;
import pl.commercelink.invoicing.api.InvoiceKind;

import java.util.List;

class CreateFinalInvoiceRequest {

    @JsonProperty("oid")
    private String oid;

    @JsonProperty("copy_invoice_from")
    private long copyInvoiceFrom;

    @JsonProperty("kind")
    private String kind = FakturowniaApiMapper.toApiInvoiceKind(InvoiceKind.Final);

    @JsonProperty("split_payment")
    private String splitPayment;

    @JsonProperty("invoice_ids")
    private List<Long> invoiceIds;

    CreateFinalInvoiceRequest(String oid, long wmsOrderId, boolean splitPayment, List<Long> invoiceIds) {
        this.oid = oid;
        this.splitPayment = splitPayment ? "1" : "0";
        this.copyInvoiceFrom = wmsOrderId;
        this.invoiceIds = invoiceIds;
    }
}
