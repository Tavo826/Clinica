package com.construccion.software.clinica.adapter.in.advice;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.application.exceptions.InputsException;
import com.construccion.software.clinica.application.exceptions.ResponseProcessingException;
import com.construccion.software.clinica.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(InputsException.class)
    public ProblemDetail handleInputsException(InputsException e) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problemDetail.setTitle("Input error");
        return problemDetail;
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleBusinessException(BusinessException e) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
        problemDetail.setTitle("Business error");
        return problemDetail;
    }

    @ExceptionHandler(ResponseProcessingException.class)
    public ProblemDetail handleResponseProcessingException(ResponseProcessingException e) {

        ErrorResponse errorResponse = e.getErrorResponse();

        ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatusCode.valueOf(e.getStatusCode()));

        if (errorResponse != null) {
            problemDetail.setTitle(errorResponse.getTitle());
            problemDetail.setDetail(errorResponse.getDetail());
            problemDetail.setInstance(URI.create(errorResponse.getInstance()));
        }

        return problemDetail;
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ProblemDetail handleAuthorizationDeniedException(AuthorizationDeniedException e) {

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.UNAUTHORIZED, e.getMessage());
        problemDetail.setTitle("Authorization denied");
        return problemDetail;
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {

        Map<String, Object> error = new HashMap<>();
        error.put("error", e.getClass().getSimpleName());
        error.put("message", e.getMessage());
        error.put("cause", e.getCause() != null ? e.getCause().getMessage() : null);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}
