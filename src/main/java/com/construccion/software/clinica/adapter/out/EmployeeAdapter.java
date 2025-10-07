package com.construccion.software.clinica.adapter.out;

import com.construccion.software.clinica.domain.models.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import com.construccion.software.clinica.infrastructure.persistence.entities.EmployeeEntity;
import com.construccion.software.clinica.infrastructure.persistence.mapper.EmployeeMapper;
import com.construccion.software.clinica.infrastructure.persistence.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeAdapter implements EmployeePort {

    private final EmployeeRepository employeeRepository;

    public EmployeeAdapter(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee findByDocument(long documentId) throws Exception {

        EmployeeEntity employeeEntity = employeeRepository.findByDocumentId(documentId);

        return EmployeeMapper.toDomain(employeeEntity);
    }

    @Override
    public void save(Employee user) throws Exception {

        employeeRepository.save(EmployeeMapper.toEntity(user));
    }

    @Override
    public void delete(long documentId) throws Exception {

        employeeRepository.deleteByDocumentId(documentId);
    }
}
