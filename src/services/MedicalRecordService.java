package services;

import entities.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService {

    private static List<MedicalRecord> records = new ArrayList<>();

    public void addRecord(MedicalRecord record) {
        records.add(record);
        System.out.println("Medical record added: " + record.getRecordId());
    }


    public MedicalRecord getRecordById(String recordId) {
        for (MedicalRecord r : records) {
            if (r.getRecordId().equals(recordId)) {
                return r;
            }
        }
        return null;
    }

    public void removeRecord(String recordId) {
        MedicalRecord record = getRecordById(recordId);
        if (record != null) {
            records.remove(record);
            System.out.println("Record removed: " + recordId);
        } else {
            System.out.println("Record not found: " + recordId);
        }
    }

    public void editRecord(String recordId, MedicalRecord updatedRecord) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getRecordId().equals(recordId)) {
                records.set(i, updatedRecord);
                System.out.println("Record updated: " + recordId);
                return;
            }
        }
        System.out.println("Record not found: " + recordId);
    }

    public List<MedicalRecord> getRecordsByPatientId(String patientId) {
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord r : records) {
            if (r.getPatientId().equals(patientId)) {
                result.add(r);
            }
        }
        return result;
    }

    public List<MedicalRecord> getRecordsByDoctorId(String doctorId) {
        List<MedicalRecord> result = new ArrayList<>();
        for (MedicalRecord r : records) {
            if (r.getDoctorId().equals(doctorId)) {
                result.add(r);
            }
        }
        return result;
    }

    public void displayPatientHistory(String patientId) {
        List<MedicalRecord> patientRecords = getRecordsByPatientId(patientId);
        if (patientRecords.isEmpty()) {
            System.out.println("No records found for patient: " + patientId);
            return;
        }
        System.out.println("===== Medical History for Patient: " + patientId + " =====");
        for (MedicalRecord r : patientRecords) {
            r.displayInfo();
            System.out.println("------------------------");
        }
    }
}