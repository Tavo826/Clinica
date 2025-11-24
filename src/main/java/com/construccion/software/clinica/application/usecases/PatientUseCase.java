package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.domain.services.patient.CreatePatient;
import com.construccion.software.clinica.domain.services.patient.GetPatient;
import com.construccion.software.clinica.domain.services.patient.UpdatePatient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientUseCase {

    private final GetPatient getPatient;
    private final CreatePatient createPatient;
    private final UpdatePatient updatePatient;

    public PatientUseCase(
            GetPatient getPatient,
            CreatePatient createPatient,
            UpdatePatient updatePatient) {
        this.getPatient = getPatient;
        this.createPatient = createPatient;
        this.updatePatient = updatePatient;
    }

    public List<Patient> getAllPatient() throws Exception {

        return getPatient.getAllPatient();
    }

    public Patient getPatientByDocumentId(long documentId) throws Exception {

        return getPatient.getByDocumentId(documentId);
    }

    public Patient createPatient(Patient patient) throws Exception {

        return createPatient.create(patient);
    }

    public Patient updatePatient(Patient patient) throws Exception {

        return updatePatient.update(patient);
    }
}
