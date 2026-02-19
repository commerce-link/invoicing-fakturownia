package pl.commercelink.invoicing.fakturownia;

import pl.commercelink.invoicing.api.InvoiceKind;

class FakturowniaApiMapper {
    static String toApiInvoiceKind(InvoiceKind kind) {
        return switch (kind) {
            case Proforma -> "proforma";
            case Estimate -> "estimate";
            case Standard -> "vat";
            case Advance -> "advance";
            case Final -> "final";
            case Receipt -> "receipt";
        };
    }
}
