package com.construccion.software.clinica.infrastructure.integration.dtos.order;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDiagnosticAssistanceDto {

    private String id;
    private String orderNumber;
    private long patientId;
    private long employeeId;
    private long itemNumber;
    private String diagnosticAssistanceName;
    private String quantity;
    private BigDecimal price;
    private LocalDate creationDate;
    private boolean requiresSpecialistAssistance;
    private long specialistId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(long itemNumber) {
        this.itemNumber = itemNumber;
    }

    public String getDiagnosticAssistanceName() {
        return diagnosticAssistanceName;
    }

    public void setDiagnosticAssistanceName(String diagnosticAssistanceName) {
        this.diagnosticAssistanceName = diagnosticAssistanceName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isRequiresSpecialistAssistance() {
        return requiresSpecialistAssistance;
    }

    public void setRequiresSpecialistAssistance(boolean requiresSpecialistAssistance) {
        this.requiresSpecialistAssistance = requiresSpecialistAssistance;
    }

    public long getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(long specialistId) {
        this.specialistId = specialistId;
    }
}
