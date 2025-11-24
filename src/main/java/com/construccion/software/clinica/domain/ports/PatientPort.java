package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.patient.Patient;

import java.util.List;

public interface PatientPort {

    List<Patient> findAll() throws Exception;
    Patient findByDocumentId(long documentId) throws Exception;
    Patient save(Patient patient) throws Exception;
    Patient update(Patient patient) throws Exception;
}
