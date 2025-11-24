package com.construccion.software.clinica.domain.services.patient;

import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

@Service
public class CreatePatient {

    private final PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public Patient create(Patient patient) throws Exception {

        return patientPort.save(patient);
    }
}
