package com.construccion.software.clinica.adapter.in.advice;

import com.construccion.software.clinica.application.exceptions.BusinessException;
import com.construccion.software.clinica.application.exceptions.InputsException;
import com.construccion.software.clinica.application.exceptions.ResponseProcessingException;
import com.construccion.software.clinica.domain.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(InputsException.class)
    public ProblemDetail handleInputsException(InputsException e) {

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
        problem.setTitle("Input error");
        return problem;
    }

    @ExceptionHandler(BusinessException.class)
    public ProblemDetail handleBusinessException(BusinessException e) {

        ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, e.getMessage());
        problem.setTitle("Business error");
        return problem;
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
}
