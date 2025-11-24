package com.construccion.software.clinica.adapter.out.integration;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import com.construccion.software.clinica.infrastructure.integration.client.GenericWebClientRequest;
import com.construccion.software.clinica.infrastructure.integration.dtos.employee.EmployeeDto;
import com.construccion.software.clinica.infrastructure.integration.mappers.EmployeeMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

@Service
public class EmployeeAdapter implements EmployeePort {

    private static final String EMPLOYEE_URI = "http://localhost:8081/api/employees";
    private final GenericWebClientRequest webClientRequest;
    private final ObjectMapper objectMapper;

    public EmployeeAdapter(GenericWebClientRequest webClientRequest, ObjectMapper objectMapper) {
        this.webClientRequest = webClientRequest;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Employee> findAll() throws Exception {

        URI getAllUri = URI.create(EMPLOYEE_URI);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getAllUri)
                .GET()
                .build();

        List<EmployeeDto> employeeDtoList = webClientRequest.sendRequest(
                request,
                new TypeReference<List<EmployeeDto>>() {}
        );

        return EmployeeMapper.toDomain(employeeDtoList);
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

        URI getByUsernameUri = URI.create(EMPLOYEE_URI + "/username/" + username);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByUsernameUri)
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

        URI saveUri = URI.create(EMPLOYEE_URI);

        String requestBody = objectMapper.writeValueAsString(employee);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        EmployeeDto employeeDto = webClientRequest.sendRequest(
                request,
                EmployeeDto.class
        );

        return EmployeeMapper.toDomain(employeeDto);
    }

    @Override
    public Employee update(Employee employee) throws Exception {

        URI updateUri = URI.create(EMPLOYEE_URI);

        String requestBody = objectMapper.writeValueAsString(employee);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(updateUri)
                .header("Content-Type", "application/json")
                .method("PATCH", HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        EmployeeDto employeeDto = webClientRequest.sendRequest(
                request,
                EmployeeDto.class
        );

        return EmployeeMapper.toDomain(employeeDto);
    }


    @Override
    public void delete(long documentId) throws Exception {

        URI deleteUri = URI.create(EMPLOYEE_URI + "/" + documentId);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(deleteUri)
                .DELETE()
                .build();

        webClientRequest.sendRequest(request, Void.class);
    }
}
