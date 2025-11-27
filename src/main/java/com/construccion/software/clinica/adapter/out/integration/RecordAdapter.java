package com.construccion.software.clinica.adapter.out.integration;

import com.construccion.software.clinica.domain.models.record.MedicalRecord;
import com.construccion.software.clinica.domain.ports.RecordPort;
import com.construccion.software.clinica.infrastructure.integration.client.GenericWebClientRequest;
import com.construccion.software.clinica.infrastructure.integration.dtos.record.MedicalRecordDto;
import com.construccion.software.clinica.infrastructure.integration.mappers.RecordMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
public class RecordAdapter implements RecordPort {

    private static final String Record_URI = "http://localhost:8085/api/records";
    private final GenericWebClientRequest webClientRequest;
    private final ObjectMapper objectMapper;

    public RecordAdapter(GenericWebClientRequest webClientRequest, ObjectMapper objectMapper) {
        this.webClientRequest = webClientRequest;
        this.objectMapper = objectMapper;
    }

    @Override
    public MedicalRecord findById(long documentId) throws Exception {

        URI getByDocumentIdUri = URI.create(Record_URI + "/" + documentId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByDocumentIdUri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        MedicalRecordDto medicalRecordDto = webClientRequest.sendRequest(request, MedicalRecordDto.class);

        return RecordMapper.toDomain(medicalRecordDto);
    }

    @Override
    public MedicalRecord save(MedicalRecord record) throws Exception {

        URI saveUri = URI.create(Record_URI);

        String requestBody = objectMapper.writeValueAsString(record);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        MedicalRecordDto medicalRecordDto = webClientRequest.sendRequest(request, MedicalRecordDto.class);

        return RecordMapper.toDomain(medicalRecordDto);
    }

    @Override
    public MedicalRecord update(long documentId, MedicalRecord record) throws Exception {

        URI updateUri = URI.create(Record_URI + "/" + documentId);

        String requestBody = objectMapper.writeValueAsString(record);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(updateUri)
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        MedicalRecordDto medicalRecordDto = webClientRequest.sendRequest(request, MedicalRecordDto.class);

        return RecordMapper.toDomain(medicalRecordDto);
    }
}
