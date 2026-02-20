# Invoicing Fakturownia

[Fakturownia](https://fakturownia.pl) implementation of the [invoicing-api](https://github.com/commerce-link/invoicing-api) provider interface.

Supports creating standard, proforma, advance, and final invoices, fetching invoices and PDFs, and looking up billing parties and cost centers via the Fakturownia REST API.

## Provider Discovery

This library registers itself for `ServiceLoader` discovery. Add it to your classpath and the provider will be available automatically via `InvoicingProviderDescriptor` SPI. See the [provider-api README](https://github.com/commerce-link/provider-api) for details.

## Configuration Fields

| Key            | Label         | Type     | Required |
|----------------|---------------|----------|----------|
| `apiUrl`       | API URL       | TEXT     | yes      |
| `apiKey`       | API Key       | PASSWORD | yes      |
| `departmentId` | Department ID | TEXT     | yes      |
