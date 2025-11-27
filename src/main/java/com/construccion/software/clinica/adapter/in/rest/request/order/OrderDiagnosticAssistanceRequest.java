package com.construccion.software.clinica.adapter.in.rest.request.order;

public class OrderDiagnosticAssistanceRequest {

    private String itemNumber;
    private String diagnosticAssistanceName;
    private String quantity;
    private boolean requiresSpecialistAssistance;
    private String specialistId;
    private String price;
    private String creationDate;

    public String getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(String itemNumber) {
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

    public boolean isRequiresSpecialistAssistance() {
        return requiresSpecialistAssistance;
    }

    public void setRequiresSpecialistAssistance(boolean requiresSpecialistAssistance) {
        this.requiresSpecialistAssistance = requiresSpecialistAssistance;
    }

    public String getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(String specialistId) {
        this.specialistId = specialistId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
