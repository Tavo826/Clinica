package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.Employee;
import com.construccion.software.clinica.domain.services.CreateEmployee;
import com.construccion.software.clinica.domain.services.DeleteEmployee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeUseCase {

    private final CreateEmployee createEmployee;
    private final DeleteEmployee deleteEmployee;

    public EmployeeUseCase(CreateEmployee createEmployee, DeleteEmployee deleteEmployee) {
        this.createEmployee = createEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    public void createEmployee(Employee employee) throws Exception {

        createEmployee.create(employee);
    }

    public void deleteEmployee(long documentId) throws Exception {

        deleteEmployee.delete(documentId);
    }



}
