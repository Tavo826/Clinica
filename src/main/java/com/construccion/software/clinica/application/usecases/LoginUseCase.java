package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.auth.AuthCredentials;
import com.construccion.software.clinica.domain.models.auth.TokenResponse;
import com.construccion.software.clinica.domain.services.AuthenticationService;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCase {

    private final AuthenticationService authenticationService;

    public LoginUseCase(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    public TokenResponse login(AuthCredentials credentials) throws Exception {

        return authenticationService.authenticate(credentials);
    }
}
