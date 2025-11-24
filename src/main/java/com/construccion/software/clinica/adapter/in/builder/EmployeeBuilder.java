package com.construccion.software.clinica.adapter.in.builder;

import com.construccion.software.clinica.adapter.in.validators.EmployeeValidator;
import com.construccion.software.clinica.adapter.in.validators.PersonValidator;
import com.construccion.software.clinica.domain.models.employee.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeBuilder {

    private final PersonValidator personValidator;
    private final EmployeeValidator employeeValidator;

    public EmployeeBuilder(PersonValidator personValidator, EmployeeValidator employeeValidator) {
        this.personValidator = personValidator;
        this.employeeValidator = employeeValidator;
    }

    public Employee build(
            String documentId,
            String name,
            String surname,
            String birthDate,
            String phone,
            String email,
            String address,
            String role,
            String username,
            String password) throws Exception, Exception {

        Employee employee = new Employee();
        employee.setDocumentId(personValidator.documentValidator(documentId));
        employee.setName(personValidator.nameValidator(name));
        employee.setSurname(personValidator.surnameValidator(surname));
        employee.setBirthDate(employeeValidator.birthDateValidator(birthDate));
        employee.setPhone(personValidator.phoneValidator(phone));
        employee.setEmail(personValidator.emailValidator(email));
        employee.setAddress(personValidator.addressValidator(address));
        employee.setRole(employeeValidator.roleValidator(role));
        employee.setUsername(employeeValidator.usernameValidator(username));
        employee.setPassword(employeeValidator.passwordValidator(password));

        return employee;
    }

    public long getDocumentId(String documentId) throws Exception {

        return personValidator.documentValidator(documentId);
    }

    public String getUsername(String username) throws Exception {

        return employeeValidator.usernameValidator(username);
    }
}
