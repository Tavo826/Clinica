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
        order.setDiagnosticAssistanceName(orderValidator.diagnosticAssistanceNameValidator(request.getOrderDiagnosticAssistanceList().get(0).getDiagnosticAssistanceName()));
        order.setQuantity(orderValidator.quantityValidator(request.getOrderDiagnosticAssistanceList().get(0).getQuantity()));
        order.setPrice(orderValidator.priceValidator(request.getOrderDiagnosticAssistanceList().get(0).getPrice()));
        order.setRequiresSpecialistAssistance(request.getOrderDiagnosticAssistanceList().get(0).isRequiresSpecialistAssistance());
        order.setSpecialistId(orderValidator.employeeIdValidator(request.getOrderDiagnosticAssistanceList().get(0).getSpecialistId()));

        return order;
    }

    public OrderMedicine buildOrderMedicine(OrderRequest request) throws Exception {

        OrderMedicine order = new OrderMedicine();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setMedicineName(orderValidator.medicineNameValidator(request.getOrderMedicineList().get(0).getMedicineName()));
        order.setDose(orderValidator.doseValidator(request.getOrderMedicineList().get(0).getDose()));
        order.setTreatmentDuration(orderValidator.treatmentDurationValidator(request.getOrderMedicineList().get(0).getTreatmentDuration()));
        order.setPrice(orderValidator.priceValidator(request.getOrderMedicineList().get(0).getPrice()));

        return order;
    }

    public OrderProcedure buildOrderProcedure(OrderRequest request) throws Exception {

        OrderProcedure order = new OrderProcedure();
        order.setOrderNumber(orderValidator.orderNumberValidator(request.getOrderNumber()));
        order.setPatientId(orderValidator.patientIdValidator(request.getPatientId()));
        order.setEmployeeId(orderValidator.employeeIdValidator(request.getEmployeeId()));
        order.setProcedureName(orderValidator.procedureNameValidator(request.getOrderProcedureList().get(0).getProcedureName()));
        order.setRepetitionNumber(orderValidator.repetitionNumberValidator(request.getOrderProcedureList().get(0).getRepetitionNumber()));
        order.setRepetitionFrequency(orderValidator.repetitionFrequencyValidator(request.getOrderProcedureList().get(0).getRepetitionFrequency()));
        order.setPrice(orderValidator.priceValidator(request.getOrderProcedureList().get(0).getPrice()));
        order.setRequiresSpecialistAssistance(request.getOrderProcedureList().get(0).isRequiresSpecialistAssistance());
        order.setSpecialistId(orderValidator.employeeIdValidator(request.getOrderProcedureList().get(0).getSpecialistId()));
        order.setBloodPressure(orderValidator.bloodPressureValidator(request.getOrderProcedureList().get(0).getBloodPressure()));
        order.setTemperature(orderValidator.temperatureValidator(request.getOrderProcedureList().get(0).getTemperature()));
        order.setPulse(orderValidator.pulseValidator(request.getOrderProcedureList().get(0).getPulse()));
        order.setBloodOxygenLevel(orderValidator.bloodOxygenValidator(request.getOrderProcedureList().get(0).getBloodOxygenLevel()));

        return order;
    }

    public String getOrderNumber(String orderNumber) throws Exception {

        return orderValidator.orderNumberValidator(orderNumber);
    }

    public long getPatientId(String patientId) throws Exception {
        return orderValidator.patientIdValidator(patientId);
    }
}
