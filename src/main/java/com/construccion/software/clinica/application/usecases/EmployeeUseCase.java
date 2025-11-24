package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.services.employee.CreateEmployee;
import com.construccion.software.clinica.domain.services.employee.DeleteEmployee;
import com.construccion.software.clinica.domain.services.employee.GetEmployee;
import com.construccion.software.clinica.domain.services.employee.UpdateEmployee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeUseCase {

    private final GetEmployee getEmployee;
    private final CreateEmployee createEmployee;
    private final UpdateEmployee updateEmployee;
    private final DeleteEmployee deleteEmployee;

    public EmployeeUseCase(
            GetEmployee getEmployee,
            CreateEmployee createEmployee,
            UpdateEmployee updateEmployee,
            DeleteEmployee deleteEmployee) {
        this.getEmployee = getEmployee;
        this.createEmployee = createEmployee;
        this.updateEmployee = updateEmployee;
        this.deleteEmployee = deleteEmployee;
    }

    public List<Employee> getAllEmployees() throws Exception {

        return getEmployee.getAllEmployees();
    }

    public Employee getEmployeeByDocumentId(long documentId) throws Exception {

        return getEmployee.getByDocumentId(documentId);
    }

    public Employee createEmployee(Employee employee) throws Exception {

        return createEmployee.create(employee);
    }

    public Employee updateEmployee(Employee employee) throws Exception {

        return updateEmployee.update(employee);
    }

    public void deleteEmployee(long employeeId) throws Exception {

        deleteEmployee.delete(employeeId);
    }

}
