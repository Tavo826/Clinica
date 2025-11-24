package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.employee.Employee;

import java.util.List;

public interface EmployeePort {

    List<Employee> findAll() throws Exception;
    Employee findByDocumentId(long documentId) throws Exception;
    Employee findByUserName(String username) throws Exception;
    Employee save(Employee employee) throws Exception;
    Employee update(Employee employee) throws Exception;
    void delete(long documentId) throws Exception;
}
