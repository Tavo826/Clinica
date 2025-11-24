package com.construccion.software.clinica.adapter.in.validators;

import com.construccion.software.clinica.domain.models.enums.Role;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeValidator extends SimpleValidator {

    public LocalDate birthDateValidator(String value) throws Exception {
        return dateValidator("fecha de nacimiento", value);
    }

    public Role roleValidator(String value) throws Exception {
        return roleValidator("rol", value);
    }

    public String usernameValidator(String value) throws Exception {
        return usernameValidator("username", value);
    }

    public String passwordValidator(String value) throws Exception {
        return passwordValidator("clave", value);
    }

}
