package com.construccion.software.clinica.adapter.in.validators;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderValidator extends SimpleValidator {

    public String idValidator(String value) throws Exception {
        return stringValidator("id de la orden", value);
    }

    public String orderNumberValidator(String value) throws Exception {
        return stringValidator("número de la orden", value);
    }

    public long patientIdValidator(String value) throws Exception {
        return longValidator("id del paciente", value);
    }

    public long employeeIdValidator(String value) throws Exception {
        return longValidator("id del empleado", value);
    }

    public long itemNumberValidator(String value) throws Exception {
        return longValidator("número del ítem", value);
    }

    public String diagnosticAssistanceNameValidator(String value) throws Exception {
        return stringValidator("nombre de la asistencia diagnóstica", value);
    }

    public Integer quantityValidator(String value) throws Exception {
        return integerValidator("cantidad", value);
    }

    public BigDecimal priceValidator(String value) throws Exception {
        return bigDecimalValidator("precio", value);
    }

    public String medicineNameValidator(String value) throws Exception {
        return stringValidator("nombre de la medicina", value);
    }

    public String doseValidator(String value) throws Exception {
        return stringValidator("dosis", value);
    }

    public String treatmentDurationValidator(String value) throws Exception {
        return stringValidator("duración", value);
    }

    public String procedureNameValidator(String value) throws Exception {
        return stringValidator("nombre de procedimiento", value);
    }

    public Integer repetitionNumberValidator(String value) throws Exception {
        return integerValidator("número de repetición", value);
    }

    public String repetitionFrequencyValidator(String value) throws Exception {
        return stringValidator("frecuencia de repetición", value);
    }
}
