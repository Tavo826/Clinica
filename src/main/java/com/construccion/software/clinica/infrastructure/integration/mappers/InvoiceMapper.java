package com.construccion.software.clinica.infrastructure.integration.mappers;

import com.construccion.software.clinica.domain.models.invoice.Invoice;
import com.construccion.software.clinica.infrastructure.integration.dtos.invoice.InvoiceDto;

import java.util.ArrayList;
import java.util.List;

public class InvoiceMapper {

    public static Invoice toDomain(InvoiceDto dto) {

        if (dto == null) return null;

        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setPatientId(dto.getPatientId());
        invoice.setEmployeeId(dto.getEmployeeId());
        invoice.setOrderId(dto.getOrderId());

        return invoice;
    }

    public static List<Invoice> toDomain(List<InvoiceDto> dtoList) {

        if (dtoList == null || dtoList.isEmpty()) return null;

        List<Invoice> invoiceList = new ArrayList<>();
        for (InvoiceDto dto : dtoList) {
            invoiceList.add(toDomain(dto));
        }

        return invoiceList;
    }
}
