package com.construccion.software.clinica.infrastructure.security;

import com.construccion.software.clinica.domain.ports.AuthenticationPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final AuthenticationPort authenticationPort;

    public JwtAuthenticationFilter(AuthenticationPort authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String token = extractToken(request);
        if (token != null) {
            processToken(token);
        }

        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {

        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }

        return null;
    }

    private void processToken(String token) {

        if (authenticationPort.validateToken(token)) {
            String username = authenticationPort.extractUsername(token);
            String role = authenticationPort.extractRole(token);

            if (role == null || role.trim().isEmpty()) {
                return;
            }

            String normalized = role.trim();
            if (!normalized.toUpperCase().startsWith("ROLE_")) {
                normalized = "ROLE_" + normalized.toUpperCase();
            } else {
                normalized = normalized.toUpperCase();
            }

            ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(normalized));

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username,
                    token,
                    authorities
            );

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
    }
}
