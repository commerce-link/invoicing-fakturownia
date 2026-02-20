package pl.commercelink.invoicing.fakturownia;

import pl.commercelink.invoicing.api.InvoicingProvider;
import pl.commercelink.invoicing.api.*;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


/*
    https://app.fakturownia.pl/api
    https://github.com/fakturownia/API?tab=readme-ov-file#f1
 */
public class FakturowniaInvoicingProvider implements InvoicingProvider {

    private final FakturowniaHttpClient httpClient;
    private final String apiKey;
    private final String departmentId;

    public FakturowniaInvoicingProvider(String apiUrl, String apiKey, String departmentId) {
        this.httpClient = new FakturowniaHttpClient(apiUrl);
        this.apiKey = apiKey;
        this.departmentId = departmentId;
    }

    @Override
    public Invoice createInvoice(InvoiceRequest request) {
        return switch (request.invoiceKind()) {
            case Advance -> createAdvanceInvoice(request);
            case Final -> createFinalInvoice(request);
            default -> createStandardInvoice(request);
        };
    }

    private Invoice createAdvanceInvoice(InvoiceRequest request) {
        GetInvoiceResult wmsOrder = fetchInvoiceResultByNumber(request.wmsOrderNo());

        CreateAdvanceInvoiceRequest invoice = new CreateAdvanceInvoiceRequest(
                request.orderId(),
                wmsOrder.getId(),
                request.paidAmount(),
                request.sellDate().toString(),
                SplitPaymentPolicy.isRequired(request.billingParty(), request.paidAmount(), request.splitPaymentsEnabled())
        );

        GetInvoiceResult result = httpClient.post("/invoices.json", new CreateInvoiceRequestWrapper(apiKey, request.send(), invoice), GetInvoiceResult.class);

        return toInvoice(result, InvoiceDirection.Sale);
    }

    private Invoice createFinalInvoice(InvoiceRequest request) {
        GetInvoiceResult wmsOrder = fetchInvoiceResultByNumber(request.wmsOrderNo());

        List<Long> invoiceIds = request.invoiceNumbers().stream()
                .map(this::fetchInvoiceResultByNumber)
                .filter(Objects::nonNull)
                .map(GetInvoiceResult::getId)
                .collect(Collectors.toList());

        CreateFinalInvoiceRequest invoice = new CreateFinalInvoiceRequest(
                request.orderId(),
                wmsOrder.getId(),
                SplitPaymentPolicy.isRequired(request.billingParty(), request.leftToPay(), request.splitPaymentsEnabled()),
                invoiceIds
        );

        GetInvoiceResult result = httpClient.post("/invoices.json", new CreateInvoiceRequestWrapper(apiKey, request.send(), invoice), GetInvoiceResult.class);

        return toInvoice(result, InvoiceDirection.Sale);
    }

    private Invoice createStandardInvoice(InvoiceRequest request) {
        InvoiceKind invoiceKind = request.invoiceKind();
        BillingParty billingParty = request.billingParty();
        List<InvoicePosition> invoicePositions = request.positions();

        CreateInvoiceRequest invoice = new CreateInvoiceRequest();
        invoice.setNumber(null);
        invoice.setOid(request.orderId());
        invoice.setCurrency("PLN");
        invoice.setLang("pl");
        invoice.setKind(FakturowniaApiMapper.toApiInvoiceKind(invoiceKind));
        invoice.setSellDate(request.sellDate().toString());
        invoice.setIssueDate(LocalDate.now().toString());
        invoice.setPaymentTo(LocalDate.now().plusDays(request.paymentTerms()).toString());
        invoice.setDescription(request.description());

        if (invoiceKind != InvoiceKind.Estimate) {
            invoice.setPaid(request.paidAmount());
        }

        double totalInvoiceValue = invoicePositions.stream()
                .mapToDouble(p -> p.price().grossValue())
                .sum();
        if (SplitPaymentPolicy.isRequired(billingParty, totalInvoiceValue, request.splitPaymentsEnabled())) {
            invoice.setSplitPayment("1");

            if (invoiceKind == InvoiceKind.Proforma) {
                invoice.setDescription("Mechanism podzielonej płatności");
            }
        } else {
            invoice.setSplitPayment("0");
        }

        invoice.setDepartmentId(this.departmentId);

        if (billingParty.hasTaxId()) {
            invoice.setBuyerCompany("1");
            invoice.setBuyerName(billingParty.company());
            invoice.setBuyerTaxNo(billingParty.taxNo());
            if (isEuVat(billingParty.taxNo())) {
                invoice.setBuyerTaxNoKind("vat");
            }
        } else {
            invoice.setBuyerCompany("0");
            invoice.setBuyerPerson("");
            invoice.setBuyerFirstName(billingParty.name());
            invoice.setBuyerLastName(billingParty.surname());
        }
        invoice.setBuyerStreet(billingParty.streetAndNumber());
        invoice.setBuyerPostCode(billingParty.postalCode());
        invoice.setBuyerCity(billingParty.city());
        invoice.setBuyerCountry(billingParty.country());

        List<CreateInvoicePositionRequest> positions = invoicePositions.stream()
                .map(i -> {
                    int tax = (int) ((i.price().vatRate() - 1) * 100);
                    return new CreateInvoicePositionRequest(i.name(), i.qty(), i.price().grossValue(), tax);
                })
                .collect(Collectors.toList());
        invoice.setPositions(positions);

        GetInvoiceResult result = httpClient.post("/invoices.json", new CreateInvoiceRequestWrapper(apiKey, request.send(), invoice), GetInvoiceResult.class);

        return toInvoice(result, InvoiceDirection.Sale);
    }

    @Override
    public Invoice fetchInvoiceById(String invoiceId, InvoiceDirection invoiceType) {
        String url = String.format("/invoices/%s.json?api_token=%s", invoiceId, apiKey);
        GetInvoiceResult result = httpClient.fetch(url, GetInvoiceResult.class);
        return result != null ? toInvoice(result, invoiceType) : null;
    }

    private GetInvoiceResult fetchInvoiceResultByNumber(String invoiceNumber) {
        String url = String.format("/invoices.json?api_token=%s&query=%s", apiKey, invoiceNumber);
        List<GetInvoiceResult> invoices = httpClient.fetchList(url, GetInvoiceResult.class);
        return (invoices != null && !invoices.isEmpty()) ? invoices.getFirst() : null;
    }

    @Override
    public List<Invoice> fetchInvoicesByOrderId(String orderId, InvoiceDirection invoiceType) {
        String url = invoiceType == InvoiceDirection.Sale
                ? String.format("/invoices.json?api_token=%s&query=%s", apiKey, orderId)
                : String.format("/invoices.json?api_token=%s&income=no&query=%s", apiKey, orderId);
        List<GetInvoiceResult> invoices = httpClient.fetchList(url, GetInvoiceResult.class);
        if (invoices == null || invoices.isEmpty()) {
            return List.of();
        }
        return invoices.stream()
                .filter(inv -> orderId.equals(inv.getOid()))
                .map(inv -> toInvoice(inv, invoiceType))
                .toList();
    }

    private Invoice toInvoice(GetInvoiceResult i, InvoiceDirection type) {

        double exchangeRate = i.getExchangeRate() > 0 ? i.getExchangeRate() : 1.0;
        String currency = i.getCurrency();

        return new Invoice(
                String.valueOf(i.getId()),
                i.getNumber(),
                i.getOid(),
                new Price(i.getPriceNet(), i.getPriceGross(), currency),
                i.getViewUrl(),
                currency,
                exchangeRate,
                "paid".equalsIgnoreCase(i.getStatus()),
                isNotBlank(i.getPaymentTo()) ? LocalDate.parse(i.getPaymentTo()) : null,
                toInvoicePositions(i, currency, exchangeRate),
                toSeller(i, type),
                toBuyer(i, type)
        );
    }

    private BillingParty toSeller(GetInvoiceResult i, InvoiceDirection type) {
        if (type == InvoiceDirection.Purchase) {
            return
                    BillingParty.company(
                            String.valueOf(i.getClientId()),
                            i.getBuyerName(),
                            i.getBuyerStreet(),
                            i.getBuyerPostCode(),
                            i.getBuyerCity(),
                            i.getBuyerCountry(),
                            i.getBuyerTaxNo(),
                            null
                    );
        }
        return null;
    }

    private BillingParty toBuyer(GetInvoiceResult i, InvoiceDirection type) {
        return null;
    }

    private static List<InvoicePosition> toInvoicePositions(GetInvoiceResult i, String currency, double exchangeRate) {
        if (i.getPositions() == null || i.getPositions().isEmpty()) {
            return Collections.emptyList();
        }

        return i.getPositions().stream()
                .map(pos -> {
                    Price p = Price.fromNet("PLN".equalsIgnoreCase(currency) ? pos.getUnitPriceNet() : pos.getUnitPriceNet() * exchangeRate);

                    return new InvoicePosition(
                            String.valueOf(pos.getId()),
                            pos.getName(),
                            (int) pos.getQuantity(),
                            p
                    );
                })
                .toList();
    }

    @Override
    public byte[] fetchInvoicePdf(String invoiceId) {
        String endpoint = String.format("/invoices/%s.pdf?api_token=%s", invoiceId, apiKey);
        return httpClient.fetch(endpoint, byte[].class);
    }

    @Override
    public BillingParty fetchCostCenterById(String costCenterId) {
        if (costCenterId == null || costCenterId.isEmpty()) {
            return null;
        }
        String url = String.format("/departments/%s.json?api_token=%s", costCenterId, apiKey);
        GetDepartmentResult result = httpClient.fetch(url, GetDepartmentResult.class);
        return result != null ? BillingParty.company(
                String.valueOf(result.getId()),
                result.getName(),
                result.getStreet(),
                result.getPostCode(),
                result.getCity(),
                result.getCountry(),
                result.getTaxNo(),
                result.getShortcut()
        ) : null;
    }

    @Override
    public BillingParty fetchBillingPartyById(String clientId) {
        if (isBlank(clientId) || !clientId.matches("\\d+")) {
            return null;
        }
        String url = String.format("/clients/%s.json?api_token=%s", clientId, apiKey);
        GetClientResult result = httpClient.fetch(url, GetClientResult.class);
        return result != null ? toBillingParty(result)  : null;
    }

    @Override
    public BillingParty fetchBillingPartyByShortcut(String billingPartyShortcut) {
        if (billingPartyShortcut == null || billingPartyShortcut.isEmpty()) {
            return null;
        }
        String url = String.format("/clients.json?api_token=%s&shortcut=%s", apiKey, billingPartyShortcut);
        List<GetClientResult> clients = httpClient.fetchList(url, GetClientResult.class);
        if (clients != null && !clients.isEmpty()) {
            return toBillingParty(clients.get(0));
        }
        return null;
    }

    private static BillingParty toBillingParty(GetClientResult result) {
        return new BillingParty(
                String.valueOf(result.getId()),
                result.getFirstName(),
                result.getLastName(),
                result.getName(),
                result.getStreet(),
                result.getPostCode(),
                result.getCity(),
                result.getCountry(),
                result.getTaxNo(),
                result.getShortcut()
        );
    }

    private static boolean isBlank(String s) {
        return s == null || s.isBlank();
    }

    private static boolean isNotBlank(String s) {
        return !isBlank(s);
    }

    private boolean isEuVat(String taxId) {
        if (taxId == null || taxId.length() < 2) {
            return false;
        }

        Collection<String> euCountryCodes = Arrays.asList(
                "AT", "BE", "BG", "HR", "CY", "CZ", "DK", "EE", "FI", "FR",
                "DE", "EL", "HU", "IE", "IT", "LV", "LT", "LU", "MT", "NL",
                "PT", "RO", "SK", "SI", "ES", "SE"
        );

        String prefix = taxId.substring(0, 2).toUpperCase();
        return euCountryCodes.contains(prefix);
    }

}
