package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.Employee;

public interface EmployeePort {

    public Employee findByDocument(long documentId) throws Exception;
    public void save(Employee user) throws Exception;
    public void delete(long documentId) throws Exception;
}
