package com.construccion.software.clinica.domain.services;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployee {

    private final EmployeePort employeePort;

    public DeleteEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void delete(long documentId) throws Exception {

        if (employeePort.findByDocument(documentId) == null) {
            throw new BusinessException("no existe una persona registrada con esa cedula");
        }

        employeePort.delete(documentId);
    }
}
