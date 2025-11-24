package com.construccion.software.clinica.domain.services.invoice;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.models.invoice.Invoice;
import com.construccion.software.clinica.domain.models.invoice.InvoiceDetails;
import com.construccion.software.clinica.domain.models.invoice.Payment;
import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import com.construccion.software.clinica.domain.ports.InvoicePort;
import com.construccion.software.clinica.domain.ports.OrderPort;
import com.construccion.software.clinica.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class GetInvoice {

    private final InvoicePort invoicePort;
    private final PatientPort patientPort;
    private final EmployeePort employeePort;
    private final OrderPort orderPort;

    private final BigDecimal coPayment = BigDecimal.valueOf(50000);
    private final BigDecimal coPaymentMax = BigDecimal.valueOf(1000000);

    public GetInvoice(
            InvoicePort invoicePort,
            PatientPort patientPort,
            EmployeePort employeePort,
            OrderPort orderPort) {
        this.invoicePort = invoicePort;
        this.patientPort = patientPort;
        this.employeePort = employeePort;
        this.orderPort = orderPort;
    }

    public Invoice getById(long invoiceId) throws Exception {

        Invoice invoice = invoicePort.findByd(invoiceId);
        Patient patient = patientPort.findByDocumentId(invoice.getPatientId());
        Employee employee = employeePort.findByDocumentId(invoice.getEmployeeId());

        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.setPatient(patient);
        invoiceDetails.setEmployee(employee);

        invoice.setDetails(invoiceDetails);

        //TODO
        var total = BigDecimal.valueOf(1000000);
        Payment payment = getPaymentValues(
                invoice.getPatientId(),
                invoiceDetails.getPatient().getHealthInsurance().getPolicyValidityDays(),
                total);

        invoice.setPayment(payment);

        return invoice;
    }

    public List<Invoice> getByPatientId(long patientId) throws Exception {

        return invoicePort.getAllByPatientId(patientId);
    }

    private Payment getPaymentValues(long patientId, long policyValidityDays, BigDecimal total) throws Exception {

        Payment payment = new Payment();
        BigDecimal coPaymentTotal = BigDecimal.ZERO;

        if (policyValidityDays > 0) {

            List<Invoice> invoiceList = invoicePort.getAllByPatientId(patientId);
            for (Invoice invoice : invoiceList) {
                if (LocalDate.now().getYear() == invoice.getCreationDate().getYear()) {
                    coPaymentTotal = coPaymentTotal.add(invoice.getPayment().getCoPayment());
                }
            }

            if (coPaymentTotal.compareTo(coPaymentMax) > 0) {
                payment.setCoPayment(BigDecimal.ZERO);
                payment.setInsurePayment(total);
                payment.setTotalPayment(total);

                return payment;
            }

            payment.setCoPayment(coPayment);
            payment.setInsurePayment(total.subtract(coPayment));
            payment.setTotalPayment(total);

            return payment;
        }

        payment.setCoPayment(total);
        payment.setInsurePayment(BigDecimal.ZERO);
        payment.setTotalPayment(total);

        return payment;
    }
}
