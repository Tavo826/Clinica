package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.invoice.Invoice;

import java.util.List;

public interface InvoicePort {

    Invoice findByd(long invoiceId) throws Exception;
    List<Invoice> getAllByPatientId(long patientId) throws Exception;
}
