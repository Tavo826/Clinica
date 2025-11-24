package com.construccion.software.clinica.infrastructure.integration.mappers;

import com.construccion.software.clinica.domain.models.ErrorResponse;
import com.construccion.software.clinica.infrastructure.integration.dtos.ErrorResponseDto;

public class ErrorMapper {

    public static ErrorResponse toDomain(ErrorResponseDto dto) {

        if (dto == null) return null;

        ErrorResponse response = new ErrorResponse();
        response.setType(dto.getType());
        response.setTitle(dto.getTitle());
        response.setStatus(dto.getStatus());
        response.setDetail(dto.getDetail());
        response.setInstance(dto.getInstance());

        return response;
    }
}
