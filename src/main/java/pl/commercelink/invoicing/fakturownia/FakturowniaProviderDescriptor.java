package pl.commercelink.invoicing.fakturownia;

import pl.commercelink.invoicing.api.InvoicingProvider;
import pl.commercelink.invoicing.api.InvoicingProviderDescriptor;
import pl.commercelink.provider.api.ProviderField;

import java.util.List;
import java.util.Map;

public class FakturowniaProviderDescriptor implements InvoicingProviderDescriptor {

    @Override
    public String name() {
        return "fakturownia";
    }

    @Override
    public String displayName() {
        return "Fakturownia";
    }

    @Override
    public List<ProviderField> configurationFields() {
        return List.of(
                new ProviderField("apiUrl", "API URL", ProviderField.FieldType.TEXT, true, "https://example.fakturownia.pl"),
                new ProviderField("apiKey", "API Key", ProviderField.FieldType.PASSWORD, true, ""),
                new ProviderField("departmentId", "Department ID", ProviderField.FieldType.TEXT, true, "")
        );
    }

    @Override
    public InvoicingProvider create(Map<String, String> configuration) {
        String apiUrl = configuration.get("apiUrl");
        String apiKey = configuration.get("apiKey");
        String departmentId = configuration.get("departmentId");
        return new FakturowniaInvoicingProvider(apiUrl, apiKey, departmentId);
    }
}
