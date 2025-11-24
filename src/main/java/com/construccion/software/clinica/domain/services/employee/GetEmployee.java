package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetEmployee {

    private final EmployeePort employeePort;

    public GetEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public List<Employee> getAllEmployees() throws Exception {

        return employeePort.findAll();
    }

    public Employee getByDocumentId(long documentId) throws Exception {

        return employeePort.findByDocumentId(documentId);
    }
}
