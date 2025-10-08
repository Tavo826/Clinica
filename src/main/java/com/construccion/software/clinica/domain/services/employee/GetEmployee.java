package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.domain.models.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class GetEmployee {

    private final EmployeePort employeePort;

    public GetEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public Employee getByDocumentId(long documentId) throws Exception {

        Employee employee = employeePort.findByDocument(documentId);
        if (employee == null) {
            throw new BusinessException("no existe una persona registrada con esa cedula");
        }

        return employee;
    }
}
