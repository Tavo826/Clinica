package com.construccion.software.clinica.adapter.in.builder;

import com.construccion.software.clinica.adapter.in.validators.EmployeeValidator;
import com.construccion.software.clinica.domain.models.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBuilder {

    private final EmployeeValidator employeeValidator;

    public EmployeeBuilder(EmployeeValidator employeeValidator) {
        this.employeeValidator = employeeValidator;
    }

    public Employee build(
            String documentId,
            String name,
            String birthDate,
            String phone,
            String email,
            String address,
            String username,
            String password) throws Exception {

        Employee employee = new Employee();
        employee.setDocumentId(employeeValidator.documentValidator(documentId));
        employee.setName(employeeValidator.nameValidator(name));
        employee.setBirthDate(employeeValidator.birthDateValidator(birthDate));
        employee.setPhone(employeeValidator.phoneValidator(phone));
        employee.setEmail(employeeValidator.emailValidator(email));
        employee.setAddress(employeeValidator.addressValidator(address));
        employee.setUsername(employeeValidator.usernameValidator(username));
        employee.setPassword(employeeValidator.passwordValidator(password));

        return employee;
    }
}
