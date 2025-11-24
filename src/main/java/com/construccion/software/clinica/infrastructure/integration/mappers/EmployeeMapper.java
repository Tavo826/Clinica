package com.construccion.software.clinica.infrastructure.integration.mappers;

import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.models.enums.Role;
import com.construccion.software.clinica.infrastructure.integration.dtos.employee.EmployeeDto;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {

    public static Employee toDomain(EmployeeDto dto) {

        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();
        employee.setDocumentId(dto.getDocumentId());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setBirthDate(dto.getBirthDate());
        employee.setPhone(dto.getPhone());
        employee.setEmail(dto.getEmail());
        employee.setAddress(dto.getAddress());
        employee.setRole(Role.valueOf(dto.getRole()));
        employee.setUsername(dto.getUsername());
        employee.setPassword(dto.getPassword());

        return employee;
    }

    public static List<Employee> toDomain(List<EmployeeDto> dtoList) {

        if (dtoList == null) {
            return null;
        }

        List<Employee> employeeList = new ArrayList<>();
        for (EmployeeDto dto : dtoList) {
            employeeList.add(toDomain(dto));
        }

        return employeeList;
    }
}
