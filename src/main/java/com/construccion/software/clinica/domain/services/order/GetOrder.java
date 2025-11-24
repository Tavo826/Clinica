package com.construccion.software.clinica.domain.services.order;

import com.construccion.software.clinica.domain.models.order.Order;
import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.domain.ports.OrderPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrder {

    private final OrderPort orderPort;

    public GetOrder(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public Order getOrderByOrderNumber(long id) throws Exception {

        List<OrderDiagnosticAssistance> orderDiagnosticAssistanceList = getOrderDiagnosticAssistanceByPatientId(id);
        List<OrderMedicine> orderMedicineList = getOrderMedicineByPatientId(id);
        List<OrderProcedure> orderProcedureList = getOrderProcedureByPatientId(id);

        Order order = new Order();
        order.setOrderDiagnosticAssistanceList(orderDiagnosticAssistanceList);
        order.setOrderMedicineList(orderMedicineList);
        order.setOrderProcedureList(orderProcedureList);

        return order;
    }

    private List<OrderDiagnosticAssistance> getOrderDiagnosticAssistanceByPatientId(long id) throws Exception {
        return orderPort.findOrderDiagnosticAssistanceByPatientId(id);
    }

    private List<OrderMedicine> getOrderMedicineByPatientId(long id) throws Exception {
        return orderPort.findOrderMedicineByPatientId(id);
    }

    private List<OrderProcedure> getOrderProcedureByPatientId(long id) throws Exception {
        return orderPort.findOrderProcedureByPatientId(id);
    }


}
