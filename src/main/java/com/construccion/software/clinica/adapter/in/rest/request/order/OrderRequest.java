package com.construccion.software.clinica.adapter.in.rest.request.order;

import java.util.List;

public class OrderRequest {

    private String orderNumber;
    private String patientId;
    private String employeeId;
    private List<OrderDiagnosticAssistanceRequest> orderDiagnosticAssistanceList;
    private List<OrderMedicineRequest> orderMedicineList;
    private List<OrderProcedureRequest> orderProcedureList;
    private String creationDate;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public List<OrderDiagnosticAssistanceRequest> getOrderDiagnosticAssistanceList() {
        return orderDiagnosticAssistanceList;
    }

    public void setOrderDiagnosticAssistanceRequestList(List<OrderDiagnosticAssistanceRequest> orderDiagnosticAssistanceList) {
        this.orderDiagnosticAssistanceList = orderDiagnosticAssistanceList;
    }

    public List<OrderMedicineRequest> getOrderMedicineList() {
        return orderMedicineList;
    }

    public void setOrderMedicineRequestList(List<OrderMedicineRequest> orderMedicineList) {
        this.orderMedicineList = orderMedicineList;
    }

    public List<OrderProcedureRequest> getOrderProcedureList() {
        return orderProcedureList;
    }

    public void setOrderProcedureList(List<OrderProcedureRequest> orderProcedureList) {
        this.orderProcedureList = orderProcedureList;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
