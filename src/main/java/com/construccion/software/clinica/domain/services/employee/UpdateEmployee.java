package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class UpdateEmployee {

    private final EmployeePort employeePort;

    public UpdateEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee update(Employee employee) throws Exception {

        return employeePort.update(employee);
    }
}
