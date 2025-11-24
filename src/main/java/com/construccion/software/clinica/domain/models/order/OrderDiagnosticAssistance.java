package com.construccion.software.clinica.domain.models.order;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDiagnosticAssistance{

    private String id;
    private String orderNumber;
    private long patientId;
    private long employeeId;
    private long itemNumber;
    private LocalDate creationDate;
    private String diagnosticAssistanceName;
    private Integer quantity;
    private BigDecimal price;

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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getDiagnosticAssistanceName() {
        return diagnosticAssistanceName;
    }

    public void setDiagnosticAssistanceName(String diagnosticAssistanceName) {
        this.diagnosticAssistanceName = diagnosticAssistanceName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
