package com.construccion.software.clinica.adapter.in.rest.request.order;

public class OrderRequest {

    private String orderNumber;
    private String patientId;
    private String employeeId;
    private String itemNumber;
    private String diagnosticAssistanceName;
    private String quantity;
    private String price;
    private String medicineName;
    private String dose;
    private String treatmentDuration;
    private String medicinePrice;
    private String procedureName;
    private String repetitionNumber;
    private String repetitionFrequency;
    private String procedurePrice;
    private boolean requiresSpecialistAssistance;
    private String specialistId;


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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public String getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(String medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public String getRepetitionNumber() {
        return repetitionNumber;
    }

    public void setRepetitionNumber(String repetitionNumber) {
        this.repetitionNumber = repetitionNumber;
    }

    public String getRepetitionFrequency() {
        return repetitionFrequency;
    }

    public void setRepetitionFrequency(String repetitionFrequency) {
        this.repetitionFrequency = repetitionFrequency;
    }

    public String getProcedurePrice() {
        return procedurePrice;
    }

    public void setProcedurePrice(String procedurePrice) {
        this.procedurePrice = procedurePrice;
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
}
