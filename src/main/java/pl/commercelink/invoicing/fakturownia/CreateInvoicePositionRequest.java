package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonProperty;

class CreateInvoicePositionRequest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("quantity_unit")
    private String quantityUnit = "szt";

    @JsonProperty("total_price_gross")
    private double totalPriceGross;

    @JsonProperty("tax")
    private int tax;

    CreateInvoicePositionRequest(String name, int quantity, double totalPriceGross, int tax) {
        this.name = name;
        this.quantity = quantity;
        this.totalPriceGross = totalPriceGross;
        this.tax = tax;
    }

    String getName() {
        return name;
    }

    int getQuantity() {
        return quantity;
    }

    double getTotalPriceGross() {
        return totalPriceGross;
    }

    int getTax() {
        return tax;
    }
}
