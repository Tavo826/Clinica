package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.domain.models.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployee {

    private final EmployeePort employeePort;

    public UpdateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void update(Employee employee) throws Exception {

        Employee actualEmployee = employeePort.findByDocument(employee.getDocumentId());
        if (actualEmployee == null) {
            throw new BusinessException("no existe una persona registrada con esa cedula");
        }

        actualEmployee.setName(employee.getName());
        actualEmployee.setBirthDate(employee.getBirthDate());
        actualEmployee.setPhone(employee.getPhone());
        actualEmployee.setEmail(employee.getEmail());
        actualEmployee.setAddress(employee.getAddress());
        actualEmployee.setRole(employee.getRole());
        actualEmployee.setUsername(employee.getUsername());
        actualEmployee.setPassword(employee.getPassword());

        employeePort.save(actualEmployee);
    }
}
