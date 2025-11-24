package com.construccion.software.clinica.infrastructure.integration.mappers;

import com.construccion.software.clinica.domain.models.enums.Gender;
import com.construccion.software.clinica.domain.models.patient.EmergencyContact;
import com.construccion.software.clinica.domain.models.patient.HealthInsurance;
import com.construccion.software.clinica.domain.models.patient.Patient;
import com.construccion.software.clinica.infrastructure.integration.dtos.patient.EmergencyContactDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.patient.HealthInsuranceDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.patient.PatientDto;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper {

    public static List<Patient> toDomain(List<PatientDto> dto) {

        if (dto == null || dto.isEmpty()) {
            return null;
        }

        List<Patient> patientList = new ArrayList<>();
        for (PatientDto patientDto : dto) {
            patientList.add(toDomain(patientDto));
        }

        return patientList;
    }

    public static Patient toDomain(PatientDto dto) {

        if (dto == null) return null;

        Patient patient = new Patient();
        patient.setDocumentId(dto.getDocumentId());
        patient.setName(dto.getName());
        patient.setSurname(dto.getSurname());
        patient.setBirthDate(dto.getBirthDate());
        patient.setPhone(dto.getPhone());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setGender(Gender.valueOf(dto.getGender()));
        patient.setEmergencyContact(toDomain(dto.getEmergencyContact()));
        patient.setHealthInsurance(toDomain(dto.getHealthInsurance()));

        return patient;
    }

    private static EmergencyContact toDomain(EmergencyContactDto dto) {

        if (dto == null) return null;

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(dto.getName());
        emergencyContact.setSurname(dto.getSurname());
        emergencyContact.setRelationship(dto.getRelationship());
        emergencyContact.setPhone(dto.getPhone());

        return emergencyContact;
    }

    private static HealthInsurance toDomain(HealthInsuranceDto dto) {

        if (dto == null) return null;

        HealthInsurance healthInsurance = new HealthInsurance();
        healthInsurance.setCompanyName(dto.getCompanyName());
        healthInsurance.setPolicyNumber(dto.getPolicyNumber());
        healthInsurance.setActive(dto.isActive());
        healthInsurance.setPolicyValidity(dto.getPolicyValidity());

        return healthInsurance;
    }
}
