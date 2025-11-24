package com.construccion.software.clinica.domain.services.order;

import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.domain.ports.OrderPort;
import org.springframework.stereotype.Service;

@Service
public class CreateOrder {

    private final OrderPort orderPort;

    public CreateOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public OrderDiagnosticAssistance create(OrderDiagnosticAssistance order) throws Exception {

        return orderPort.save(order);
    }

    public OrderMedicine create(OrderMedicine order) throws Exception {

        return orderPort.save(order);
    }

    public OrderProcedure create(OrderProcedure order) throws Exception {

        return orderPort.save(order);
    }
}
