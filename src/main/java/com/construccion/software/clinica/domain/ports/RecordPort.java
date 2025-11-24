package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.record.MedicalRecord;

public interface RecordPort {

    MedicalRecord findById(long documentId) throws Exception;
    MedicalRecord save(MedicalRecord record) throws Exception;
}
