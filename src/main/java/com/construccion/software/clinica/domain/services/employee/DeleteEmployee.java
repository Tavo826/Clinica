package com.construccion.software.clinica.domain.services.employee;

import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class DeleteEmployee {

    private final EmployeePort employeePort;

    public DeleteEmployee(EmployeePort employeePort) {
        this.employeePort = employeePort;
    }

    public void delete(long documentId) throws Exception {

        employeePort.delete(documentId);
    }
}
