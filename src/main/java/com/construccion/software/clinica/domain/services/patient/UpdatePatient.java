package com.construccion.software.clinica.domain.services.patient;

import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

@Service
public class UpdatePatient {

    private final PatientPort patientPort;

    public UpdatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public Patient update(Patient patient) throws Exception {

        Patient updatedPatient = patientPort.update(patient);

        return updatedPatient;
    }
}
