package com.construccion.software.clinica.domain.services.record;

import com.construccion.software.clinica.domain.models.record.MedicalRecord;
import com.construccion.software.clinica.domain.ports.RecordPort;
import org.springframework.stereotype.Service;

@Service
public class CreateRecord {

    private final RecordPort recordPort;

    public CreateRecord(RecordPort recordPort) {
        this.recordPort = recordPort;
    }

    public MedicalRecord create(MedicalRecord medicalRecord) throws Exception {

        return recordPort.save(medicalRecord);
    }
}
