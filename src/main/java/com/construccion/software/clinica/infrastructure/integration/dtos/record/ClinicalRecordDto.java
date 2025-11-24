package com.construccion.software.clinica.infrastructure.integration.dtos.record;

import java.util.List;

public class ClinicalRecordDto {

    private long employeeId;
    private String reason;
    private String symptomatology;
    private String diagnosis;
    private List<MedicineDto> medicationList;
    private List<ProcedureDto> procedureList;
    private List<DiagnosticAssistanceDto> diagnosticAssistanceList;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSymptomatology() {
        return symptomatology;
    }

    public void setSymptomatology(String symptomatology) {
        this.symptomatology = symptomatology;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public List<MedicineDto> getMedicationList() {
        return medicationList;
    }

    public void setMedicationList(List<MedicineDto> medicationList) {
        this.medicationList = medicationList;
    }

    public List<ProcedureDto> getProcedureList() {
        return procedureList;
    }

    public void setProcedureList(List<ProcedureDto> procedureList) {
        this.procedureList = procedureList;
    }

    public List<DiagnosticAssistanceDto> getDiagnosticAssistanceList() {
        return diagnosticAssistanceList;
    }

    public void setDiagnosticAssistanceList(List<DiagnosticAssistanceDto> diagnosticAssistanceList) {
        this.diagnosticAssistanceList = diagnosticAssistanceList;
    }
}
