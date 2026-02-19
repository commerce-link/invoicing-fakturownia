package pl.commercelink.invoicing.fakturownia;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
class GetInvoicePositionResult {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("quantity")
    private double quantity;

    @JsonProperty("total_price_net")
    private double totalPriceNet;

    @JsonProperty("total_price_gross")
    private double totalPriceGross;

    @JsonProperty("tax")
    private String tax;

    @JsonProperty("code")
    private String code;

    long getId() {
        return id;
    }

    String getName() {
        return name;
    }

    double getQuantity() {
        return quantity;
    }

    double getTotalPriceNet() {
        return totalPriceNet;
    }

    double getTotalPriceGross() {
        return totalPriceGross;
    }

    String getTax() {
        return tax;
    }

    String getCode() {
        return code;
    }

    double getUnitPriceNet() {
        if (quantity == 0) {
            return 0;
        }
        return Math.round(totalPriceNet / quantity * 100.0) / 100.0;
    }

    double getUnitPriceGross() {
        if (quantity == 0) {
            return 0;
        }
        return Math.round(totalPriceGross / quantity * 100.0) / 100.0;
    }
}
