package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.adapter.in.builder.EmployeeBuilder;
import com.construccion.software.clinica.adapter.in.rest.request.EmployeeRequest;
import com.construccion.software.clinica.application.exceptions.InputsException;
import com.construccion.software.clinica.domain.models.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeBuilder employeeBuilder;

    public EmployeeController(EmployeeBuilder employeeBuilder) {
        this.employeeBuilder = employeeBuilder;
    }

    @PostMapping("/Employee")
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

            //usecase

        } catch (InputsException ie) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(ie.getMessage());

        /*} catch (BusinessException be) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(be.getMessage());*/

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
