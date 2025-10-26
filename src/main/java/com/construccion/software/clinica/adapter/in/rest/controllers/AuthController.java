package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.application.usecases.LoginUseCase;
import com.construccion.software.clinica.domain.models.auth.AuthCredentials;
import com.construccion.software.clinica.domain.models.auth.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthCredentials credentials) throws Exception {

        TokenResponse response = loginUseCase.login(credentials);

        return ResponseEntity.ok(response);
    }
}
