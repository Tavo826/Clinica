package com.construccion.software.clinica.domain.models;

import java.util.Date;

public class Patient extends Person {

    private String gender;

    //Información de contacto de emergencia
    private String contactName;
    private String relation;
    private String contactPhone;

    //Información seguro médico
    private String insuranceCompanyName;
    private long policyNumber;
    private Boolean policyStatus;
    private Date policyValidityDate;

}
