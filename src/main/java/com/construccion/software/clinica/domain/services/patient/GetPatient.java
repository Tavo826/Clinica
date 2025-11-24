package com.construccion.software.clinica.domain.services.patient;

import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.domain.ports.PatientPort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class GetPatient {

    private final PatientPort patientPort;

    public GetPatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public List<Patient> getAllPatient() throws Exception {

        List<Patient> patientList = patientPort.findAll();
        patientList.forEach(patient -> patient.setAge(calculateAge(patient.getBirthDate())));

        return patientList;
    }

    public Patient getByDocumentId(long documentId) throws Exception {

        Patient patient = patientPort.findByDocumentId(documentId);
        patient.setAge(calculateAge(patient.getBirthDate()));

        return patient;
    }

    private int calculateAge(LocalDate birthDate) {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}
