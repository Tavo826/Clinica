package com.construccion.software.clinica.infrastructure.integration.dtos.patient;

import java.time.LocalDate;

public class PatientDto {

    private long documentId;
    private String name;
    private String surname;
    private long phone;
    private String email;
    private String address;
    private LocalDate birthDate;
    private String gender;
    private EmergencyContactDto emergencyContact;
    private HealthInsuranceDto healthInsurance;

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public EmergencyContactDto getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(EmergencyContactDto emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public HealthInsuranceDto getHealthInsurance() {
        return healthInsurance;
    }

    public void setHealthInsurance(HealthInsuranceDto healthInsurance) {
        this.healthInsurance = healthInsurance;
    }
}
