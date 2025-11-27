package com.construccion.software.clinica.domain.services.record;

import com.construccion.software.clinica.domain.models.invoice.Invoice;
import com.construccion.software.clinica.domain.models.record.ClinicalRecord;
import com.construccion.software.clinica.domain.models.record.MedicalRecord;
import com.construccion.software.clinica.domain.ports.InvoicePort;
import com.construccion.software.clinica.domain.ports.RecordPort;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CreateRecord {

    private final RecordPort recordPort;
    private final InvoicePort invoicePort;

    public CreateRecord(RecordPort recordPort, InvoicePort invoicePort) {
        this.recordPort = recordPort;
        this.invoicePort = invoicePort;
    }

    public MedicalRecord create(MedicalRecord medicalRecord) throws Exception {

        Map.Entry<String, ClinicalRecord> infoEntry = medicalRecord.getClinicalRecords().entrySet().iterator().next();
        createInvoice(medicalRecord.getDocumentId(), infoEntry.getValue().getEmployeeId());
        return recordPort.save(medicalRecord);
    }

    private void createInvoice(long patientId, long employeeId) throws Exception {

        Invoice invoice = new Invoice();
        invoice.setPatientId(patientId);
        invoice.setEmployeeId(employeeId);

        invoicePort.save(invoice);
    }
}
