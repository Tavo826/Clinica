package com.construccion.software.clinica.domain.services.order;

import com.construccion.software.clinica.domain.models.order.OrderDiagnosticAssistance;
import com.construccion.software.clinica.domain.models.order.OrderMedicine;
import com.construccion.software.clinica.domain.models.order.OrderProcedure;
import com.construccion.software.clinica.domain.models.record.*;
import com.construccion.software.clinica.domain.ports.OrderPort;
import com.construccion.software.clinica.domain.ports.RecordPort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CreateOrder {

    private final OrderPort orderPort;
    private final RecordPort recordPort;

    public CreateOrder(OrderPort orderPort, RecordPort recordPort) {
        this.orderPort = orderPort;
        this.recordPort = recordPort;
    }

    public OrderDiagnosticAssistance create(OrderDiagnosticAssistance order) throws Exception {

        long patientId = order.getPatientId();

        verifyOrder(patientId, true);
        OrderDiagnosticAssistance createdOrder = orderPort.save(order);

        saveRecord(patientId, createdOrder, null, null);

        return createdOrder;
    }

    public OrderMedicine create(OrderMedicine order) throws Exception {

        long patientId = order.getPatientId();

        verifyOrder(patientId, false);

        OrderMedicine createdOrder = orderPort.save(order);

        saveRecord(order.getPatientId(), null, createdOrder, null);

        return createdOrder;
    }

    public OrderProcedure create(OrderProcedure order) throws Exception {

        long patientId = order.getPatientId();

        verifyOrder(patientId, false);

        OrderProcedure createdOrder = orderPort.save(order);

        saveRecord(order.getPatientId(), null, null, createdOrder);

        return createdOrder;
    }

    private void verifyOrder(long patientId, boolean isDiagnostic) throws Exception {

        List<OrderDiagnosticAssistance> orderDiagnosticAssistanceList = orderPort.findOrderDiagnosticAssistanceByPatientId(patientId);

        if (orderDiagnosticAssistanceList.isEmpty() && !isDiagnostic) {
            throw new Exception("Debe generar la orden de ayuda diagnóstica");
        }
    }

    private void saveRecord(
            long patientDocumentId,
            OrderDiagnosticAssistance orderdiagnosticassistance,
            OrderMedicine orderMedicine,
            OrderProcedure orderProcedure) throws Exception {

        MedicalRecord medicalRecord = recordPort.findById(patientDocumentId);
        Map<String, ClinicalRecord> newClinicalRecordMap = generateRecord(orderdiagnosticassistance, orderMedicine, orderProcedure, medicalRecord);

        if (medicalRecord == null) {
            MedicalRecord newMedicalRecord = new MedicalRecord();
            newMedicalRecord.setDocumentId(patientDocumentId);
            newMedicalRecord.setClinicalRecords(newClinicalRecordMap);

            recordPort.save(newMedicalRecord);
        } else {
            Map<String, ClinicalRecord> clinicalRecordMap = medicalRecord.getClinicalRecords();
            clinicalRecordMap.putAll(newClinicalRecordMap);

            recordPort.update(patientDocumentId, medicalRecord);
        }
    }

    private Map<String, ClinicalRecord> generateRecord(
            OrderDiagnosticAssistance orderdiagnosticassistance,
            OrderMedicine orderMedicine,
            OrderProcedure orderProcedure,
            MedicalRecord medicalRecord) {

        Map<String, ClinicalRecord> clinicalRecordMap = new HashMap<>();
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        Map.Entry<String, ClinicalRecord> infoEntry = medicalRecord.getClinicalRecords().entrySet().iterator().next();
        clinicalRecord.setEmployeeId(infoEntry.getValue().getEmployeeId());
        clinicalRecord.setDiagnosis(infoEntry.getValue().getDiagnosis());
        clinicalRecord.setReason(infoEntry.getValue().getReason());
        clinicalRecord.setSymptomatology(infoEntry.getValue().getSymptomatology());

        if (orderdiagnosticassistance != null) {

            List<DiagnosticAssistance> diagnosticAssistanceList = new ArrayList<>();
            DiagnosticAssistance diagnosticAssistance = new DiagnosticAssistance();
            diagnosticAssistance.setOrderNumber(orderdiagnosticassistance.getOrderNumber());
            diagnosticAssistance.setQuantity(orderdiagnosticassistance.getQuantity());
            diagnosticAssistance.setItemId(orderdiagnosticassistance.getItemNumber());
            diagnosticAssistance.setRequiresSpecialistAssistance(orderdiagnosticassistance.isRequiresSpecialistAssistance());
            diagnosticAssistance.setSpecialistId(orderdiagnosticassistance.getSpecialistId());

            diagnosticAssistanceList.add(diagnosticAssistance);


            clinicalRecord.setEmployeeId(orderdiagnosticassistance.getEmployeeId());
            clinicalRecord.setDiagnosticAssistanceList(diagnosticAssistanceList);
        }

        if (orderMedicine != null) {

            List<Medicine> medicineList = new ArrayList<>();
            Medicine medicine = new Medicine();
            medicine.setOrderNumber(orderMedicine.getOrderNumber());
            medicine.setDose(orderMedicine.getDose());
            medicine.setTreatmentDuration(orderMedicine.getTreatmentDuration());
            medicine.setItemId(orderMedicine.getItemNumber());

            medicineList.add(medicine);

            clinicalRecord.setEmployeeId(orderMedicine.getEmployeeId());
            clinicalRecord.setMedicationList(medicineList);
        }

        if (orderProcedure != null) {

            List<Procedure> procedureList = new ArrayList<>();
            Procedure procedure = new Procedure();
            procedure.setOrderNumber(orderProcedure.getOrderNumber());
            procedure.setRepetitionNumber(orderProcedure.getRepetitionNumber());
            procedure.setRepetitionFrequency(orderProcedure.getRepetitionFrequency());
            procedure.setRequiresSpecialistAssistance(orderProcedure.isRequiresSpecialistAssistance());
            procedure.setSpecialistId(orderProcedure.getSpecialistId());
            procedure.setItemId(orderProcedure.getItemNumber());

            procedureList.add(procedure);

            clinicalRecord.setEmployeeId(orderProcedure.getEmployeeId());
            clinicalRecord.setProcedureList(procedureList);
        }

        clinicalRecordMap.put(LocalDateTime.now().toString()
                .replace(":", "-")
                .replace(".", "-"), clinicalRecord);

        return clinicalRecordMap;
    }
}
