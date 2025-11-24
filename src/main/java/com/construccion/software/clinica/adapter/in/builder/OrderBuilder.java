package com.construccion.software.clinica.adapter.in.builder;

import com.construccion.software.clinica.adapter.in.rest.request.order.OrderRequest;
import com.construccion.software.clinica.adapter.in.validators.OrderValidator;
import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import org.springframework.stereotype.Component;

@Component
public class OrderBuilder {

    private final OrderValidator orderValidator;

    public OrderBuilder(OrderValidator orderValidator) {
        this.orderValidator = orderValidator;
    }

    public OrderDiagnosticAssistance buildOrderDiagnosticAssistance(OrderRequest request) throws Exception {

        OrderDiagnosticAssistance order = new OrderDiagnosticAssistance();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setItemNumber(orderValidator.itemNumberValidator(request.getItemNumber()));
        order.setDiagnosticAssistanceName(orderValidator.diagnosticAssistanceNameValidator(request.getDiagnosticAssistanceName()));
        order.setQuantity(orderValidator.quantityValidator(request.getQuantity()));
        order.setPrice(orderValidator.priceValidator(request.getPrice()));

        return order;
    }

    public OrderMedicine buildOrderMedicine(OrderRequest request) throws Exception {

        OrderMedicine order = new OrderMedicine();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setItemNumber(orderValidator.itemNumberValidator(request.getItemNumber()));
        order.setMedicineName(orderValidator.medicineNameValidator(request.getMedicineName()));
        order.setDose(orderValidator.doseValidator(request.getDose()));
        order.setTreatmentDuration(orderValidator.treatmentDurationValidator(request.getTreatmentDuration()));
        order.setPrice(orderValidator.priceValidator(request.getPrice()));

        return order;
    }

    public OrderProcedure buildOrderProcedure(OrderRequest request) throws Exception {

        OrderProcedure order = new OrderProcedure();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setItemNumber(orderValidator.itemNumberValidator(request.getItemNumber()));
        order.setProcedureName(orderValidator.procedureNameValidator(request.getProcedureName()));
        order.setRepetitionNumber(orderValidator.repetitionNumberValidator(request.getRepetitionNumber()));
        order.setRepetitionFrequency(orderValidator.repetitionFrequencyValidator(request.getRepetitionFrequency()));
        order.setPrice(orderValidator.priceValidator(request.getPrice()));
        order.setRequiresSpecialistAssistance(request.isRequiresSpecialistAssistance());
        order.setSpecialistId(orderValidator.employeeIdValidator(request.getSpecialistId()));

        return order;
    }

    public String getOrderNumber(String orderNumber) throws Exception {

        return orderValidator.orderNumberValidator(orderNumber);
    }

    public long getPatientId(String patientId) throws Exception {
        return orderValidator.patientIdValidator(patientId);
    }
}
