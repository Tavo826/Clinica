package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.adapter.in.builder.EmployeeBuilder;
import com.construccion.software.clinica.adapter.in.rest.request.EmployeeRequest;
import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.application.exceptions.InputsException;
import com.construccion.software.clinica.application.usecases.EmployeeUseCase;
import com.construccion.software.clinica.domain.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private final EmployeeBuilder employeeBuilder;
    private final EmployeeUseCase employeeUseCase;

    public EmployeeController(EmployeeBuilder employeeBuilder, EmployeeUseCase employeeUseCase) {
        this.employeeBuilder = employeeBuilder;
        this.employeeUseCase = employeeUseCase;
    }

    @PostMapping("/Employees")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest request) {

        try {
            Employee employee = employeeBuilder.build(
                    request.getDocumentId(),
                    request.getName(),
                    request.getBirthDate(),
                    request.getPhone(),
                    request.getEmail(),
                    request.getAddress(),
                    request.getUsername(),
                    request.getPassword()
            );

            employeeUseCase.createEmployee(employee);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(employee);

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("Employees/{documentId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String documentId) {

        try {

            employeeUseCase.deleteEmployee(employeeBuilder.getDocumentId(documentId));

            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        } catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
