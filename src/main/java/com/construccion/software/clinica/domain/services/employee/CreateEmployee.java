package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class CreateEmployee {

    private final EmployeePort employeePort;

    public CreateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee create(Employee employee) throws Exception {

        return employeePort.save(employee);
    }
}
