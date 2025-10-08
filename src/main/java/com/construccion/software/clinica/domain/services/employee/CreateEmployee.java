package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.domain.models.Employee;
import com.construccion.software.clinica.domain.models.enums.Role;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployee {

    private final EmployeePort employeePort;

    public CreateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void create(Employee employee) throws Exception {

        if (!Role.containsRoleName(employee.getRole().name())){
            throw new BusinessException("El rol no es válido");
        }

        if (employeePort.findByDocument(employee.getDocumentId()) != null) {
            throw new BusinessException("ya existe una persona registrada con esa cedula");
        }

        employeePort.save(employee);

    }
}
