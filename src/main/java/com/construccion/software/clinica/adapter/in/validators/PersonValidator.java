package com.construccion.software.clinica.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PersonValidator extends SimpleValidator {

    public long documentValidator(String value) throws Exception {
        return longValidator("el documento de la persona", value);
    }

    public String nameValidator(String value) throws Exception {
        return stringValidator("nombre de la persona", value);
    }

    public String surnameValidator(String value) throws Exception {
        return stringValidator("apellido de la persona", value);
    }

    public LocalDate birthDateValidator(String value) throws Exception {
        return dateValidator("fecha de nacimiento", value);
    }

    public long phoneValidator(String value) throws Exception {
        return phoneValidator("teléfono", value);
    }

    public String emailValidator(String value) throws Exception {
        return emailValidator("email", value);
    }

    public String addressValidator(String value) throws Exception {
        return addressValidator("dirección", value);
    }
}
