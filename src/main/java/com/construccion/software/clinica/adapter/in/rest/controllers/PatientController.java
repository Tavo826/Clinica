package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.adapter.in.builder.PatientBuilder;
import com.construccion.software.clinica.adapter.in.rest.request.patient.PatientRequest;
import com.construccion.software.clinica.application.usecases.PatientUseCase;
import com.construccion.software.clinica.domain.models.patient.Patient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    private final PatientBuilder patientBuilder;
    private final PatientUseCase patientUseCase;

    public PatientController(PatientBuilder patientBuilder, PatientUseCase patientUseCase) {
        this.patientBuilder = patientBuilder;
        this.patientUseCase = patientUseCase;
    }

    @GetMapping("/{documentId}")
    @PreAuthorize("hasRole('NURSE') or hasRole('ADMINISTRATIVE')")
    public ResponseEntity<Patient> getPatient(@PathVariable String documentId) throws Exception {

        Patient patient = patientUseCase.getPatientByDocumentId(patientBuilder.getDocumentId(documentId));

        return ResponseEntity.ok(patient);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMINISTRATIVE')")
    public ResponseEntity<?> getAllPatients() throws Exception {

        List<Patient> patientList = patientUseCase.getAllPatient();

        return ResponseEntity.ok(patientList);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMINISTRATIVE')")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest request) throws Exception {

        Patient patient = patientBuilder.build(request);

        Patient createdPatient = patientUseCase.createPatient(patient);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdPatient);
    }

    @PatchMapping
    @PreAuthorize("hasRole('ADMINISTRATIVE')")
    public ResponseEntity<?> updatePatient(@RequestBody PatientRequest request) throws Exception {

        Patient patient = patientBuilder.build(request);

        Patient updatedPatient = patientUseCase.updatePatient(patient);

        return ResponseEntity.ok(updatedPatient);
    }
}
