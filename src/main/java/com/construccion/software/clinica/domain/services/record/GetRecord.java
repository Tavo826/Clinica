package com.construccion.software.clinica.domain.services.record;

import com.construccion.software.clinica.domain.models.record.MedicalRecord;
import com.construccion.software.clinica.domain.ports.RecordPort;
import org.springframework.stereotype.Service;

@Service
public class GetRecord {

    private final RecordPort recordPort;

    public GetRecord(RecordPort recordPort) {
        this.recordPort = recordPort;
    }

    public MedicalRecord getById(long documentId) throws Exception {

        return recordPort.findById(documentId);
    }
}
