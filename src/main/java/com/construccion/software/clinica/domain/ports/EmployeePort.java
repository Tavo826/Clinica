package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.Employee;

public interface EmployeePort {

    public Employee findByDocumentId(long documentId) throws Exception;
    public Employee findByUserName(String username) throws Exception;
    public Employee save(Employee employee) throws Exception;
}
