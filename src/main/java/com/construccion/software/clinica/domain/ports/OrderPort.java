package com.construccion.software.clinica.domain.ports;

import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;

import java.util.List;

public interface OrderPort {

    List<OrderDiagnosticAssistance> findOrderDiagnosticAssistanceByPatientId(long id) throws Exception;
    List<OrderMedicine> findOrderMedicineByPatientId(long id) throws Exception;
    List<OrderProcedure> findOrderProcedureByPatientId(long id) throws Exception;
    OrderDiagnosticAssistance save(OrderDiagnosticAssistance order) throws Exception;
    OrderMedicine save(OrderMedicine order) throws Exception;
    OrderProcedure save(OrderProcedure order) throws Exception;
}
