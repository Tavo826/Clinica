package com.construccion.software.clinica.infrastructure.integration.mappers;

import com.construccion.software.clinica.domain.models.record.*;
import com.construccion.software.clinica.infrastructure.integration.dtos.record.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecordMapper {

    public static MedicalRecordDto toEntity(MedicalRecord record) {

        if (record == null) return null;

        MedicalRecordDto dto = new MedicalRecordDto();
        dto.setDocumentId(record.getDocumentId());
        dto.setClinicalRecords(toEntity(record.getClinicalRecords()));

        return dto;
    }

    public static Map<String, ClinicalRecordDto> toEntity(Map<String, ClinicalRecord> clinicalRecordMap) {

        if (clinicalRecordMap == null) return null;

        Map<String, ClinicalRecordDto> clinicalRecordDtoMap = new HashMap<String, ClinicalRecordDto>();
        clinicalRecordMap.forEach((key, value) -> {
            clinicalRecordDtoMap.put(key, toEntity(value));
        });

        return clinicalRecordDtoMap;
    }

    public static ClinicalRecordDto toEntity(ClinicalRecord clinicalRecord) {

        if (clinicalRecord == null) return null;

        ClinicalRecordDto dto = new ClinicalRecordDto();
        dto.setEmployeeId(clinicalRecord.getEmployeeId());
        dto.setReason(clinicalRecord.getReason());
        dto.setSymptomatology(clinicalRecord.getSymptomatology());
        dto.setDiagnosis(clinicalRecord.getDiagnosis());
        dto.setMedicationList(toMedicineEntity(clinicalRecord.getMedicationList()));
        dto.setProcedureList(toProcedureEntity(clinicalRecord.getProcedureList()));
        dto.setDiagnosticAssistanceList(toDiagnosticAssistanceEntity(clinicalRecord.getDiagnosticAssistanceList()));

        return dto;
    }

    public static List<MedicineDto> toMedicineEntity(List<Medicine> medicineList) {

        if (medicineList == null) return null;

        List<MedicineDto> dtoList = new ArrayList<MedicineDto>();
        medicineList.forEach(medicine -> {
            dtoList.add(toEntity(medicine));
        });

        return dtoList;
    }

    public static MedicineDto toEntity(Medicine medicine) {

        if (medicine == null) return null;

        MedicineDto dto = new MedicineDto();
        dto.setOrderNumber(medicine.getOrderNumber());
        dto.setMedicineId(medicine.getMedicineId());
        dto.setDose(medicine.getDose());
        dto.setTreatmentDuration(medicine.getTreatmentDuration());

        return dto;
    }

    public static List<ProcedureDto> toProcedureEntity(List<Procedure> procedureList) {

        if (procedureList == null) return null;

        List<ProcedureDto> dtoList = new ArrayList<>();
        procedureList.forEach(procedure -> {
            dtoList.add(toEntity(procedure));
        });

        return dtoList;
    }

    public static ProcedureDto toEntity(Procedure procedure) {

        if (procedure == null) return null;

        ProcedureDto dto = new ProcedureDto();
        dto.setOrderNumber(procedure.getOrderNumber());
        dto.setProcedureId(procedure.getProcedureId());
        dto.setRepetitionNumber(procedure.getRepetitionNumber());
        dto.setRepetitionFrequency(procedure.getRepetitionFrequency());
        dto.setRequiresSpecialistAssistance(procedure.isRequiresSpecialistAssistance());
        dto.setSpecialistId(procedure.getSpecialistId());
        dto.setItemId(procedure.getItemId());

        return dto;
    }

    public static List<DiagnosticAssistanceDto> toDiagnosticAssistanceEntity(List<DiagnosticAssistance> diagnosticAssistanceList) {

        if (diagnosticAssistanceList == null) return null;

        List<DiagnosticAssistanceDto> dtoList = new ArrayList<>();
        diagnosticAssistanceList.forEach(diagnosticAssistance -> {
            dtoList.add(toEntity(diagnosticAssistance));
        });

        return dtoList;
    }

    public static DiagnosticAssistanceDto toEntity(DiagnosticAssistance diagnosticAssistance) {

        if (diagnosticAssistance == null) return null;

        DiagnosticAssistanceDto dto = new DiagnosticAssistanceDto();
        dto.setOrderNumber(diagnosticAssistance.getOrderNumber());
        dto.setDiagnosticAssistanceId(diagnosticAssistance.getDiagnosticAssistanceId());
        dto.setQuantity(diagnosticAssistance.getQuantity());
        dto.setItemId(diagnosticAssistance.getItemId());
        dto.setRequiresSpecialistAssistance(diagnosticAssistance.isRequiresSpecialistAssistance());
        dto.setSpecialistId(diagnosticAssistance.getSpecialistId());

        return dto;
    }

    public static MedicalRecord toDomain(MedicalRecordDto entity) {

        if (entity == null) return null;

        MedicalRecord record = new MedicalRecord();
        record.setDocumentId(entity.getDocumentId());
        record.setClinicalRecords(toDomain(entity.getClinicalRecords()));

        return record;
    }

    public static Map<String, ClinicalRecord> toDomain(Map<String, ClinicalRecordDto> clinicalRecordDtoMap) {

        if (clinicalRecordDtoMap == null) return null;

        Map<String, ClinicalRecord> clinicalRecordMap = new HashMap<String, ClinicalRecord>();
        clinicalRecordDtoMap.forEach((key, value) -> {
            clinicalRecordMap.put(key, toDomain(value));
        });

        return clinicalRecordMap;
    }

    public static ClinicalRecord toDomain(ClinicalRecordDto dto) {

        if (dto == null) return null;

        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setEmployeeId(dto.getEmployeeId());
        clinicalRecord.setReason(dto.getReason());
        clinicalRecord.setSymptomatology(dto.getSymptomatology());
        clinicalRecord.setDiagnosis(dto.getDiagnosis());
        clinicalRecord.setMedicationList(toMedicineDomain(dto.getMedicationList()));
        clinicalRecord.setProcedureList(toProcedureDomain(dto.getProcedureList()));
        clinicalRecord.setDiagnosticAssistanceList(toDiagnosticAssistanceDomain(dto.getDiagnosticAssistanceList()));

        return clinicalRecord;
    }

    public static List<Medicine> toMedicineDomain(List<MedicineDto> medicineDtoList) {

        if (medicineDtoList == null) return null;

        List<Medicine> medicineList = new ArrayList<Medicine>();
        medicineDtoList.forEach(medicine -> {
            medicineList.add(toDomain(medicine));
        });

        return medicineList;
    }

    public static Medicine toDomain(MedicineDto dto) {

        if (dto == null) return null;

        Medicine medicine = new Medicine();
        medicine.setOrderNumber(dto.getOrderNumber());
        medicine.setMedicineId(dto.getMedicineId());
        medicine.setDose(dto.getDose());
        medicine.setTreatmentDuration(dto.getTreatmentDuration());

        return medicine;
    }

    public static List<Procedure> toProcedureDomain(List<ProcedureDto> procedureDtoList) {

        if (procedureDtoList == null) return null;

        List<Procedure> procedureList = new ArrayList<>();
        procedureDtoList.forEach(procedure -> {
            procedureList.add(toDomain(procedure));
        });

        return procedureList;
    }

    public static Procedure toDomain(ProcedureDto dto) {

        if (dto == null) return null;

        Procedure procedure = new Procedure();
        procedure.setOrderNumber(dto.getOrderNumber());
        procedure.setProcedureId(dto.getProcedureId());
        procedure.setRepetitionNumber(dto.getRepetitionNumber());
        procedure.setRepetitionFrequency(dto.getRepetitionFrequency());
        procedure.setRequiresSpecialistAssistance(dto.isRequiresSpecialistAssistance());
        procedure.setSpecialistId(dto.getSpecialistId());
        procedure.setItemId(dto.getItemId());

        return procedure;
    }

    public static List<DiagnosticAssistance> toDiagnosticAssistanceDomain(List<DiagnosticAssistanceDto> diagnosticAssistanceDtoList) {

        if (diagnosticAssistanceDtoList == null) return null;

        List<DiagnosticAssistance> diagnosticAssistanceList = new ArrayList<>();
        diagnosticAssistanceDtoList.forEach(diagnosticAssistance -> {
            diagnosticAssistanceList.add(toDomain(diagnosticAssistance));
        });

        return diagnosticAssistanceList;
    }

    public static DiagnosticAssistance toDomain(DiagnosticAssistanceDto dto) {

        if (dto == null) return null;

        DiagnosticAssistance diagnosisAssistance = new DiagnosticAssistance();
        diagnosisAssistance.setOrderNumber(dto.getOrderNumber());
        diagnosisAssistance.setDiagnosticAssistanceId(dto.getDiagnosticAssistanceId());
        diagnosisAssistance.setQuantity(dto.getQuantity());
        diagnosisAssistance.setItemId(dto.getItemId());
        diagnosisAssistance.setRequiresSpecialistAssistance(dto.isRequiresSpecialistAssistance());
        diagnosisAssistance.setSpecialistId(dto.getSpecialistId());

        return diagnosisAssistance;
    }
}
