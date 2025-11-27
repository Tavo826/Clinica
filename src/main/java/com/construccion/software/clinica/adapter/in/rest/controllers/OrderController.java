package com.construccion.software.clinica.adapter.in.rest.controllers;

import com.construccion.software.clinica.adapter.in.builder.OrderBuilder;
import com.construccion.software.clinica.adapter.in.rest.request.order.OrderRequest;
import com.construccion.software.clinica.application.usecases.OrderUseCase;
import com.construccion.software.clinica.domain.models.order.Order;
import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@PreAuthorize("hasRole('NURSE') or hasRole('DOCTOR')")
public class OrderController {

    private final OrderBuilder orderBuilder;
    private final OrderUseCase orderUseCase;

    public OrderController(OrderBuilder orderBuilder, OrderUseCase orderUseCase) {
        this.orderBuilder = orderBuilder;
        this.orderUseCase = orderUseCase;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderByOrderPatientId(@PathVariable String id) throws Exception {

        Order order = orderUseCase.getOrderByPatientId(orderBuilder.getPatientId(id));

        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody OrderRequest request) throws Exception {

        if (!request.getOrderDiagnosticAssistanceList().isEmpty()) {

            OrderDiagnosticAssistance order = orderBuilder.buildOrderDiagnosticAssistance(request);

            orderUseCase.createOrder(order);
        }

        if (!request.getOrderMedicineList().isEmpty()) {

            OrderMedicine order = orderBuilder.buildOrderMedicine(request);

            orderUseCase.createOrder(order);
        }

        if (!request.getOrderProcedureList().isEmpty()) {

            OrderProcedure order = orderBuilder.buildOrderProcedure(request);

            orderUseCase.createOrder(order);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
