package com.construccion.software.clinica.domain.models.order;

import java.util.List;

public class Order {

    private List<OrderDiagnosticAssistance> orderDiagnosticAssistanceList;
    private List<OrderMedicine> orderMedicineList;
    private List<OrderProcedure> orderProcedureList;

    public List<OrderDiagnosticAssistance> getOrderDiagnosticAssistanceList() {
        return orderDiagnosticAssistanceList;
    }

    public void setOrderDiagnosticAssistanceList(List<OrderDiagnosticAssistance> orderDiagnosticAssistanceList) {
        this.orderDiagnosticAssistanceList = orderDiagnosticAssistanceList;
    }

    public List<OrderMedicine> getOrderMedicineList() {
        return orderMedicineList;
    }

    public void setOrderMedicineList(List<OrderMedicine> orderMedicineList) {
        this.orderMedicineList = orderMedicineList;
    }

    public List<OrderProcedure> getOrderProcedureList() {
        return orderProcedureList;
    }

    public void setOrderProcedureList(List<OrderProcedure> orderProcedureList) {
        this.orderProcedureList = orderProcedureList;
    }
}
