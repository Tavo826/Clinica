package com.construccion.software.clinica.application.exceptions;

import com.construccion.software.clinica.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;

public class ResponseProcessingException extends Exception {

    private final int statusCode;
    private final ErrorResponse errorResponse;

    public ResponseProcessingException(String message, int statusCode, ErrorResponse errorResponse, Throwable cause) {
        super(message, cause);
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public ResponseProcessingException(String message,Throwable cause) {
        super(message, cause);
        this.statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        this.errorResponse = null;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
