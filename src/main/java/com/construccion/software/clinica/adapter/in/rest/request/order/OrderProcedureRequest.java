package com.construccion.software.clinica.adapter.in.rest.request.order;

public class OrderProcedureRequest {

    private String itemId;
    private String procedureName;
    private String repetitionNumber;
    private String repetitionFrequency;
    private boolean requiresSpecialistAssistance;
    private String specialistId;
    private String price;
    private String bloodPressure;
    private String temperature;
    private String pulse;
    private String bloodOxygenLevel;
    private String creationDate;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
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

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPulse() {
        return pulse;
    }

    public void setPulse(String pulse) {
        this.pulse = pulse;
    }

    public String getBloodOxygenLevel() {
        return bloodOxygenLevel;
    }

    public void setBloodOxygenLevel(String bloodOxygenLevel) {
        this.bloodOxygenLevel = bloodOxygenLevel;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
