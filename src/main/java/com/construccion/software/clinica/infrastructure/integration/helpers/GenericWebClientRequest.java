package com.construccion.software.clinica.infrastructure.integration.helpers;

import com.construccion.software.clinica.application.exceptions.ResponseProcessingException;
import com.construccion.software.clinica.infrastructure.integration.dtos.ErrorResponseDto;
import com.construccion.software.clinica.infrastructure.integration.mappers.ErrorMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

@Component
public class GenericWebClientRequest {

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public GenericWebClientRequest() {
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();

        this.objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public <T> T sendRequest(HttpRequest request, Class<T> responseType) throws Exception {

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

            int statusCode = response.statusCode();
            String body = response.body();

            try {
                return objectMapper.readValue(body, responseType);
            } catch (JsonProcessingException jsonProcessingException) {
                ErrorResponseDto errorResponseDto = objectMapper.readValue(body, ErrorResponseDto.class);
                throw new ResponseProcessingException("Error response", statusCode, ErrorMapper.toDomain(errorResponseDto), jsonProcessingException);
            }

        } catch (IOException e) {
            throw new ResponseProcessingException("Communication error", e);
        }
    }
}
