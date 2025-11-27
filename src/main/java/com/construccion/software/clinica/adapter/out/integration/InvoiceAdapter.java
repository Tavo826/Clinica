package com.construccion.software.clinica.adapter.out.integration;

import com.construccion.software.clinica.domain.models.invoice.Invoice;
import com.construccion.software.clinica.domain.ports.InvoicePort;
import com.construccion.software.clinica.infrastructure.integration.client.GenericWebClientRequest;
import com.construccion.software.clinica.infrastructure.integration.dtos.invoice.InvoiceDto;
import com.construccion.software.clinica.infrastructure.integration.mappers.InvoiceMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

@Service
public class InvoiceAdapter implements InvoicePort {

    private static final String Invoice_URI = "http://localhost:8083/api/invoices";
    private final GenericWebClientRequest webClientRequest;
    private final ObjectMapper objectMapper;

    public InvoiceAdapter(GenericWebClientRequest webClientRequest, ObjectMapper objectMapper) {
        this.webClientRequest = webClientRequest;
        this.objectMapper = objectMapper;
    }


    @Override
    public Invoice findByd(long invoiceId) throws Exception {

        URI getByIdUri = URI.create(Invoice_URI + "/" + invoiceId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByIdUri)
                .header("Accept", "application/json")
                .GET()
                .build();

        InvoiceDto invoice = webClientRequest.sendRequest(request, InvoiceDto.class);

        return InvoiceMapper.toDomain(invoice);
    }

    @Override
    public List<Invoice> getAllByPatientId(long patientId) throws Exception {

        URI getAllByPatientIdUri = URI.create(Invoice_URI + "/patients/" + patientId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getAllByPatientIdUri)
                .header("Accept", "application/json")
                .GET()
                .build();

        List<InvoiceDto> invoiceList = webClientRequest.sendRequest(request, new TypeReference<List<InvoiceDto>>() {});

        return InvoiceMapper.toDomain(invoiceList);
    }

    @Override
    public Invoice save(Invoice invoice) throws Exception {

        URI saveUri = URI.create(Invoice_URI);

        String requestBody = objectMapper.writeValueAsString(invoice);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        InvoiceDto invoiceDto = webClientRequest.sendRequest(request, InvoiceDto.class);

        return InvoiceMapper.toDomain(invoiceDto);
    }
}
