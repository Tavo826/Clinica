package com.construccion.software.clinica.adapter.out.integration;

import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.domain.ports.OrderPort;
import com.construccion.software.clinica.infrastructure.integration.client.GenericWebClientRequest;
import com.construccion.software.clinica.infrastructure.integration.dtos.invoice.InvoiceDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.order.OrderDiagnosticAssistanceDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.order.OrderMedicineDto;
import com.construccion.software.clinica.infrastructure.integration.dtos.order.OrderProcedureDto;
import com.construccion.software.clinica.infrastructure.integration.mappers.OrderMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.util.List;

@Service
public class OrderAdapter implements OrderPort {

    private static final String Order_URI = "http://localhost:8084/api/orders";
    private final GenericWebClientRequest webClientRequest;
    private final ObjectMapper objectMapper;

    public OrderAdapter(ObjectMapper objectMapper, GenericWebClientRequest webClientRequest) {
        this.webClientRequest = webClientRequest;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<OrderDiagnosticAssistance> findOrderDiagnosticAssistanceByPatientId(long id) throws Exception {

        URI getByIdUri = URI.create(Order_URI + "/diagnosis/patients/" + id);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByIdUri)
                .header("Accept", "application/json")
                .GET()
                .build();

        List<OrderDiagnosticAssistanceDto> orderDto = webClientRequest.sendRequest(request, new TypeReference<List<OrderDiagnosticAssistanceDto>>() {});

        return OrderMapper.toDomainOrderDiagnosticAssistance(orderDto);
    }

    @Override
    public List<OrderMedicine> findOrderMedicineByPatientId(long id) throws Exception {

        URI getByIdUri = URI.create(Order_URI + "/medicine/patients/" + id);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByIdUri)
                .header("Accept", "application/json")
                .GET()
                .build();

        List<OrderMedicineDto> orderDto = webClientRequest.sendRequest(request, new TypeReference<List<OrderMedicineDto>>() {});

        return OrderMapper.toDomainOrderMedicine(orderDto);
    }

    @Override
    public List<OrderProcedure> findOrderProcedureByPatientId(long id) throws Exception {

        URI getByIdUri = URI.create(Order_URI + "/procedure/patients" + id);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(getByIdUri)
                .header("Accept", "application/json")
                .GET()
                .build();

        List<OrderProcedureDto> orderDto = webClientRequest.sendRequest(request, new TypeReference<List<OrderProcedureDto>>() {});

        return OrderMapper.toDomainOrderProcedure(orderDto);
    }

    @Override
    public OrderDiagnosticAssistance save(OrderDiagnosticAssistance order) throws Exception {

        URI saveUri = URI.create(Order_URI + "/diagnosis");

        String requestBody = objectMapper.writeValueAsString(order);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        OrderDiagnosticAssistanceDto orderDto = webClientRequest.sendRequest(request, OrderDiagnosticAssistanceDto.class);

        return OrderMapper.toDomain(orderDto);
    }

    @Override
    public OrderMedicine save(OrderMedicine order) throws Exception {

        URI saveUri = URI.create(Order_URI + "/medicine");

        String requestBody = objectMapper.writeValueAsString(order);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        OrderMedicineDto orderDto = webClientRequest.sendRequest(request, OrderMedicineDto.class);

        return OrderMapper.toDomain(orderDto);
    }

    @Override
    public OrderProcedure save(OrderProcedure order) throws Exception {

        URI saveUri = URI.create(Order_URI + "/procedure");

        String requestBody = objectMapper.writeValueAsString(order);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(saveUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        OrderProcedureDto orderDto = webClientRequest.sendRequest(request, OrderProcedureDto.class);

        return OrderMapper.toDomain(orderDto);
    }
}
