package com.construccion.software.clinica.application.usecases;

import com.construccion.software.clinica.domain.models.order.Order;
import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.domain.services.order.CreateOrder;
import com.construccion.software.clinica.domain.services.order.GetOrder;
import org.springframework.stereotype.Service;

@Service
public class OrderUseCase {

    private final CreateOrder createOrder;
    private final GetOrder getOrder;

    public OrderUseCase(CreateOrder createOrder, GetOrder getOrder) {
        this.createOrder = createOrder;
        this.getOrder = getOrder;
    }

    public Order getOrderByOrderNumber(long id) throws Exception {

        return getOrder.getOrderByOrderNumber(id);
    }

    public void createOrder(OrderDiagnosticAssistance order) throws Exception {

        createOrder.create(order);
    }

    public void createOrder(OrderMedicine order) throws Exception {

        createOrder.create(order);
    }

    public void createOrder(OrderProcedure order) throws Exception {

        createOrder.create(order);
    }
}
