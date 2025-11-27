package com.construccion.software.clinica.infrastructure.integration.mappers;

import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.infrastructure.integration.dtos.order.OrderDiagnosticAssistanceDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.order.OrderMedicineDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.order.OrderProcedureDto;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<OrderDiagnosticAssistance> toDomainOrderDiagnosticAssistance(List<OrderDiagnosticAssistanceDto> dtoList) {

        if (dtoList == null) {
            return null;
        }

        List<OrderDiagnosticAssistance> orderList = new ArrayList<>();
        dtoList.forEach(orderDiagnosticAssistanceDto -> {
            orderList.add(toDomain(orderDiagnosticAssistanceDto));
        });

        return orderList;
    }

    public static List<OrderMedicine> toDomainOrderMedicine(List<OrderMedicineDto> dtoList) {

        if (dtoList == null) {
            return null;
        }

        List<OrderMedicine> orderList = new ArrayList<>();
        dtoList.forEach(orderMedicineDto -> {
            orderList.add(toDomain(orderMedicineDto));
        });

        return orderList;
    }

    public static List<OrderProcedure> toDomainOrderProcedure(List<OrderProcedureDto> dtoList) {

        if (dtoList == null) {
            return null;
        }

        List<OrderProcedure> orderList = new ArrayList<>();
        dtoList.forEach(orderProcedureDto -> {
            orderList.add(toDomain(orderProcedureDto));
        });

        return orderList;
    }

    public static OrderDiagnosticAssistance toDomain(OrderDiagnosticAssistanceDto dto) {

        if (dto == null) return null;

        OrderDiagnosticAssistance order = new OrderDiagnosticAssistance();
        order.setId(dto.getId());
        order.setOrderNumber(dto.getOrderNumber());
        order.setPatientId(dto.getPatientId());
        order.setEmployeeId(dto.getEmployeeId());
        order.setItemNumber(dto.getItemNumber());
        order.setCreationDate(dto.getCreationDate());
        order.setDiagnosticAssistanceName(dto.getDiagnosticAssistanceName());
        order.setQuantity(dto.getQuantity());
        order.setPrice(dto.getPrice());
        order.setRequiresSpecialistAssistance(dto.isRequiresSpecialistAssistance());
        order.setSpecialistId(dto.getSpecialistId());

        return order;
    }

    public static OrderMedicine toDomain(OrderMedicineDto dto) {

        if (dto == null) return null;

        OrderMedicine order = new OrderMedicine();
        order.setId(dto.getId());
        order.setOrderNumber(dto.getOrderNumber());
        order.setPatientId(dto.getPatientId());
        order.setEmployeeId(dto.getEmployeeId());
        order.setItemNumber(dto.getItemNumber());
        order.setCreationDate(dto.getCreationDate());
        order.setMedicineName(dto.getMedicineName());
        order.setDose(dto.getDose());
        order.setTreatmentDuration(dto.getTreatmentDuration());
        order.setPrice(dto.getPrice());

        return order;
    }

    public static OrderProcedure toDomain(OrderProcedureDto dto) {

        if (dto == null) return null;

        OrderProcedure order = new OrderProcedure();
        order.setId(dto.getId());
        order.setOrderNumber(dto.getOrderNumber());
        order.setPatientId(dto.getPatientId());
        order.setEmployeeId(dto.getEmployeeId());
        order.setItemNumber(dto.getItemNumber());
        order.setCreationDate(dto.getCreationDate());
        order.setProcedureName(dto.getProcedureName());
        order.setRepetitionNumber(dto.getRepetitionNumber());
        order.setRepetitionFrequency(dto.getRepetitionFrequency());
        order.setPrice(dto.getPrice());
        order.setRequiresSpecialistAssistance(dto.isRequiresSpecialistAssistance());
        order.setSpecialistId(dto.getSpecialistId());
        order.setBloodPressure(dto.getBloodPressure());
        order.setTemperature(dto.getTemperature());
        order.setPulse(dto.getPulse());
        order.setBloodOxygenLevel(dto.getBloodOxygenLevel());

        return order;
    }
}
