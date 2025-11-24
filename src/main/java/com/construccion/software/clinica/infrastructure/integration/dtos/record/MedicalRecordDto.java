package com.construccion.software.clinica.infrastructure.integration.dtos.record;

import java.util.Map;

public class MedicalRecordDto {

    private long documentId;
    private Map<String, ClinicalRecordDto> clinicalRecords;

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public Map<String, ClinicalRecordDto> getClinicalRecords() {
        return clinicalRecords;
    }

    public void setClinicalRecords(Map<String, ClinicalRecordDto> clinicalRecords) {
        this.clinicalRecords = clinicalRecords;
    }
}
