package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.adapter.in.builder.RecordBuilder;
import com.construccion.software.clinica.adapter.in.rest.request.record.RecordRequest;
import com.construccion.software.clinica.application.usecases.RecordUseCase;
import com.construccion.software.clinica.domain.models.record.MedicalRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasRole('NURSE') or hasRole('DOCTOR')")
@RequestMapping("api/records")
public class RecordController {

    private final RecordBuilder recordBuilder;
    private final RecordUseCase recordUseCase;

    public RecordController(RecordBuilder recordBuilder, RecordUseCase recordUseCase) {
        this.recordBuilder = recordBuilder;
        this.recordUseCase = recordUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRecordById(@PathVariable String id) throws Exception {

        MedicalRecord record = recordUseCase.getRecordById(recordBuilder.getId(id));

        return ResponseEntity.ok(record);

    }

    @PostMapping
    public ResponseEntity<?> createRecord(@RequestBody RecordRequest request) throws Exception {

        MedicalRecord medicalRecord = recordBuilder.build(request);

        MedicalRecord createdMedicalRecord = recordUseCase.createRecord(medicalRecord);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createdMedicalRecord);
    }
}
