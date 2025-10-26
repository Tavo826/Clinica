package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.auth.AuthCredentials;
import com.construccion.software.clinica.domain.models.auth.TokenResponse;

public interface AuthenticationPort {
    TokenResponse authenticate(AuthCredentials credentials, String role);
    boolean validateToken(String token);
    String extractUsername(String token);
    String extractRole(String token);
}
