package com.construccion.software.clinica.infrastructure.persistence.repository;

import com.construccion.software.clinica.infrastructure.persistence.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    public EmployeeEntity findByDocumentId(long documentId);
    public void deleteByDocumentId(long documentId);
}
