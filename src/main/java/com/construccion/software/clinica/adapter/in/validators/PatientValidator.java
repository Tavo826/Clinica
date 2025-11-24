package com.construccion.software.clinica.adapter.in.validators;

import com.construccion.software.clinica.domain.models.enums.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PatientValidator extends SimpleValidator {

    public Gender genderValidator(String value) throws Exception {
        return genderValidator("género", value);
    }

    public String relationshipValidator(String value) throws Exception {
        return stringValidator("parentesco", value);
    }

    public String companyNameValidator(String value) throws Exception {
        return stringValidator("nombre de empresa", value);
    }

    public long policyNumberValidator(String value) throws Exception {
        return longValidator("número de póliza", value);
    }

    public LocalDate policyValidityValidator(String value) throws Exception {
        return dateValidator("fecha de vencimiento", value);
    }
}
