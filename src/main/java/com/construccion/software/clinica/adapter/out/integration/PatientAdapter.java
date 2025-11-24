package com.construccion.software.clinica.adapter.out.integration;

import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.domain.ports.PatientPort;
import com.construccion.software.clinica.infrastructure.integration.client.GenericWebClientRequest;
import com.construccion.software.clinica.infrastructure.integration.dtos.patient.PatientDto;
import com.construccion.software.clinica.infrastructure.integration.mappers.PatientMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

@Service
public class PatientAdapter implements PatientPort {

    private static final String Patient_URI = "http://localhost:8082/api/patients";
    private final GenericWebClientRequest webClientRequest;
    private final ObjectMapper objectMapper;

    public PatientAdapter(ObjectMapper objectMapper, GenericWebClientRequest webClientRequest) {
        this.webClientRequest = webClientRequest;
        this.objectMapper = objectMapper;
    }


    @Override
    public List<Patient> findAll() throws Exception {

        URI findAllUri = URI.create(Patient_URI);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(findAllUri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        List<PatientDto> patientListDto = webClientRequest.sendRequest(request, new TypeReference<List<PatientDto>>() {});

        return PatientMapper.toDomain(patientListDto);
    }

    @Override
    public Patient findByDocumentId(long documentId) throws Exception {

        URI getByDocumentIdUri = URI.create(Patient_URI + "/" + documentId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByDocumentIdUri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        PatientDto patientDto = webClientRequest.sendRequest(request, PatientDto.class);

        return PatientMapper.toDomain(patientDto);
    }

    @Override
    public Patient save(Patient patient) throws Exception {

        URI saveUri = URI.create(Patient_URI);

        String requestBody = objectMapper.writeValueAsString(patient);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        PatientDto patientDto = webClientRequest.sendRequest(request, PatientDto.class);

        return PatientMapper.toDomain(patientDto);
    }

    @Override
    public Patient update(Patient patient) throws Exception {

        URI updateUri = URI.create(Patient_URI);

        String requestBody = objectMapper.writeValueAsString(patient);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(updateUri)
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        PatientDto patientDto = webClientRequest.sendRequest(request, PatientDto.class);

        return PatientMapper.toDomain(patientDto);
    }
}
