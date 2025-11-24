package com.construccion.software.clinica.domain.models.record;

import java.util.Map;

public class MedicalRecord {

    private long documentId;
    private Map<String, ClinicalRecord> clinicalRecords;

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public Map<String, ClinicalRecord> getClinicalRecords() {
        return clinicalRecords;
    }

    public void setClinicalRecords(Map<String, ClinicalRecord> clinicalRecords) {
        this.clinicalRecords = clinicalRecords;
    }
}
