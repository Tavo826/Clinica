package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.record.MedicalRecord;
import com.construccion.software.clinica.domain.services.record.CreateRecord;
import com.construccion.software.clinica.domain.services.record.GetRecord;
import org.springframework.stereotype.Service;

@Service
public class RecordUseCase {

    private final GetRecord getRecord;
    private final CreateRecord createRecord;

    public RecordUseCase(GetRecord getRecord, CreateRecord createRecord) {
        this.getRecord = getRecord;
        this.createRecord = createRecord;
    }

    public MedicalRecord getRecordById(long documentId) throws Exception {

        return getRecord.getById(documentId);
    }

    public MedicalRecord createRecord(MedicalRecord medicalRecord) throws Exception {

        return createRecord.create(medicalRecord);
    }
}
