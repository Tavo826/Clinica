package com.construccion.software.clinica.domain.services;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.domain.models.auth.AuthCredentials;
import com.construccion.software.clinica.domain.models.auth.TokenResponse;
import com.construccion.software.clinica.domain.models.employee.Employee;
import com.construccion.software.clinica.domain.ports.AuthenticationPort;
import com.construccion.software.clinica.domain.ports.EmployeePort;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final AuthenticationPort authenticationPort;
    private final EmployeePort employeePort;

    public AuthenticationService(AuthenticationPort authenticationPort, EmployeePort employeePort) {
        this.authenticationPort = authenticationPort;
        this.employeePort = employeePort;
    }

    public TokenResponse authenticate(AuthCredentials credentials) throws Exception {

        Employee employee = getEmployeeByUsername(credentials.getUsername());
        validatePassword(credentials.getPassword(), employee.getPassword());
        return authenticationPort.authenticate(credentials, String.valueOf(employee.getRole()));
    }

    private Employee getEmployeeByUsername(String username) throws Exception {

        Employee employee = employeePort.findByUserName(username);
        if (employee == null) {
            throw new BusinessException("Usuario no encontrado");
        }

        return employee;
    }

    private void validatePassword(String inputPassword, String storedPassword) throws Exception {

        if(!inputPassword.equals(storedPassword)) {
            throw new BusinessException("Contraseña incorrecta");
        }

    }

}
