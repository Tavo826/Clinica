package com.construccion.software.clinica.domain.models.invoice;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.domain.models.patient.Patient;

public class InvoiceDetails {

    private Patient patient;
    private Employee employee;
    private OrderDiagnosticAssistance orderDiagnosticAssistance;
    private OrderMedicine orderMedicine;
    private OrderProcedure orderProcedure;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public OrderDiagnosticAssistance getOrderDiagnosticAssistance() {
        return orderDiagnosticAssistance;
    }

    public void setOrderDiagnosticAssistance(OrderDiagnosticAssistance orderDiagnosticAssistance) {
        this.orderDiagnosticAssistance = orderDiagnosticAssistance;
    }

    public OrderMedicine getOrderMedicine() {
        return orderMedicine;
    }

    public void setOrderMedicine(OrderMedicine orderMedicine) {
        this.orderMedicine = orderMedicine;
    }

    public OrderProcedure getOrderProcedure() {
        return orderProcedure;
    }

    public void setOrderProcedure(OrderProcedure orderProcedure) {
        this.orderProcedure = orderProcedure;
    }
}
