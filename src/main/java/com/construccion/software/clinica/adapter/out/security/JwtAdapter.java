package com.construccion.software.clinica.adapter.out.security;

import com.construccion.software.clinica.domain.models.auth.AuthCredentials;
import com.construccion.software.clinica.domain.models.auth.TokenResponse;
import com.construccion.software.clinica.domain.ports.AuthenticationPort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtAdapter implements AuthenticationPort {

    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 60 * 60 * 1000;

    @Override
    public TokenResponse authenticate(AuthCredentials credentials, String role) {

        String token = generateToken(credentials.getUsername(), role);

        TokenResponse tokenResponse = new TokenResponse();
        tokenResponse.setToken(token);

        return tokenResponse;
    }

    @Override
    public boolean validateToken(String token) {

        try {
            getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String extractUsername(String token) {

        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    @Override
    public String extractRole(String token) {

        Claims claims = getClaims(token);
        return claims.get("role", String.class);
    }

    private String generateToken(String username, String role) {

        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder()
                .setSubject(username)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiration)
                .signWith(SECRET_KEY)
                .compact();
    }

    private Claims getClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
