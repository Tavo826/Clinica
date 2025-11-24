package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.invoice.Invoice;
import com.construccion.software.clinica.domain.services.invoice.GetInvoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceUseCase {

    private final GetInvoice getInvoice;

    public InvoiceUseCase(GetInvoice getInvoice) {
        this.getInvoice = getInvoice;
    }

    public Invoice getInvoiceById(long invoiceId) throws Exception {

        return getInvoice.getById(invoiceId);
    }

    public List<Invoice> getInvoicesByPatientId(long patientId) throws Exception {

        return getInvoice.getByPatientId(patientId);
    }
}
