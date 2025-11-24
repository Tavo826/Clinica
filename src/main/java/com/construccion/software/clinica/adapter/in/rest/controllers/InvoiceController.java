package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.adapter.in.builder.PatientBuilder;
import com.construccion.software.clinica.application.usecases.InvoiceUseCase;
import com.construccion.software.clinica.domain.models.invoice.Invoice;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/invoices")
@PreAuthorize("hasRole('ADMINISTRATIVE')")
public class InvoiceController {

    private final PatientBuilder patientBuilder;
    private final InvoiceUseCase invoiceUseCase;

    public InvoiceController(PatientBuilder patientBuilder, InvoiceUseCase invoiceUseCase) {
        this.patientBuilder = patientBuilder;
        this.invoiceUseCase = invoiceUseCase;
    }

    @GetMapping("/{invoiceId}")
    public ResponseEntity<?> getInvoiceById(@PathVariable String invoiceId) throws Exception {

        Invoice invoice = invoiceUseCase.getInvoiceById(patientBuilder.getDocumentId(invoiceId));

        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/patients/{patientId}")
    public ResponseEntity<?> getInvoiceListByPatientId(@PathVariable String patientId) throws Exception {

        List<Invoice> invoiceList = invoiceUseCase.getInvoicesByPatientId(patientBuilder.getDocumentId(patientId));

        return ResponseEntity.ok(invoiceList);
    }
}
