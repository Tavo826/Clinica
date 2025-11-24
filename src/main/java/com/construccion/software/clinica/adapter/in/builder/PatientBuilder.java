package com.construccion.software.clinica.adapter.in.builder;

import com.construccion.software.clinica.adapter.in.rest.request.patient.PatientRequest;
import com.construccion.software.clinica.adapter.in.validators.PatientValidator;
import com.construccion.software.clinica.adapter.in.validators.PersonValidator;
import com.construccion.software.clinica.domain.models.patient.EmergencyContact;
import com.construccion.software.clinica.domain.models.patient.HealthInsurance;
import com.construccion.software.clinica.domain.models.patient.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientBuilder {

    private final PersonValidator personValidator;
    private final PatientValidator patientValidator;

    public PatientBuilder(PersonValidator personValidator, PatientValidator patientValidator) {
        this.personValidator = personValidator;
        this.patientValidator = patientValidator;
    }

    public Patient build(PatientRequest request) throws Exception {

        EmergencyContact emergencyContact = new EmergencyContact();
        emergencyContact.setName(personValidator.nameValidator(request.getEmergencyContact().getName()));
        emergencyContact.setSurname(personValidator.surnameValidator(request.getEmergencyContact().getSurname()));
        emergencyContact.setRelationship(patientValidator.relationshipValidator(request.getEmergencyContact().getRelationship()));
        emergencyContact.setPhone(personValidator.phoneValidator(request.getEmergencyContact().getPhone()));

        HealthInsurance healthInsurance = new HealthInsurance();
        healthInsurance.setCompanyName(patientValidator.companyNameValidator(request.getHealthInsurance().getCompanyName()));
        healthInsurance.setPolicyNumber(patientValidator.policyNumberValidator(request.getHealthInsurance().getPolicyNumber()));
        healthInsurance.setActive(request.getHealthInsurance().isActive());
        healthInsurance.setPolicyValidity(patientValidator.policyValidityValidator(request.getHealthInsurance().getPolicyValidity()));

        Patient patient = new Patient();
        patient.setDocumentId(personValidator.documentValidator(request.getDocumentId()));
        patient.setName(personValidator.nameValidator(request.getName()));
        patient.setSurname(personValidator.surnameValidator(request.getSurname()));
        patient.setBirthDate(personValidator.birthDateValidator(request.getBirthDate()));
        patient.setPhone(personValidator.phoneValidator(request.getPhone()));
        patient.setEmail(personValidator.emailValidator(request.getEmail()));
        patient.setAddress(personValidator.addressValidator(request.getAddress()));
        patient.setGender(patientValidator.genderValidator(request.getGender()));
        patient.setEmergencyContact(emergencyContact);
        patient.setHealthInsurance(healthInsurance);

        return patient;
    }

    public long getDocumentId(String documentId) throws Exception {

        return personValidator.documentValidator(documentId);
    }
}
