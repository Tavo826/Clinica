package com.construccion.software.clinica.adapter.out.integration;

import com.construccion.software.clinica.domain.models.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import com.construccion.software.clinica.infrastructure.integration.dtos.EmployeeDto;
import com.construccion.software.clinica.infrastructure.integration.helpers.GenericWebClientRequest;
import com.construccion.software.clinica.infrastructure.integration.mappers.EmployeeMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;

@Service
public class EmployeeAdapter implements EmployeePort {

    private static final String EMPLOYEE_URI = "http://localhost:8081/Employees";
    private final GenericWebClientRequest webClientRequest;
    private final ObjectMapper objectMapper;

    public EmployeeAdapter(GenericWebClientRequest webClientRequest) {
        this.webClientRequest = webClientRequest;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Employee findByDocumentId(long documentId) throws Exception {

        URI getByDocumentUri = URI.create(EMPLOYEE_URI + "/document/" + documentId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByDocumentUri)
                .GET()
                .build();

        EmployeeDto employeeDto = webClientRequest.sendRequest(
                request,
                EmployeeDto.class
        );

        return EmployeeMapper.toDomain(employeeDto);
    }

    @Override
    public Employee findByUserName(String username) throws Exception {

        URI getByUsername = URI.create(EMPLOYEE_URI + "/username/" + username);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByUsername)
                .GET()
                .build();

        EmployeeDto employeeDto = webClientRequest.sendRequest(
                request,
                EmployeeDto.class
        );

        return EmployeeMapper.toDomain(employeeDto);
    }

    @Override
    public Employee save(Employee employee) throws Exception {

        URI getByUsername = URI.create(EMPLOYEE_URI);

        String requestBody = objectMapper.writeValueAsString(employee);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByUsername)
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        EmployeeDto employeeDto = webClientRequest.sendRequest(
                request,
                EmployeeDto.class
        );

        return EmployeeMapper.toDomain(employeeDto);
    }
}
