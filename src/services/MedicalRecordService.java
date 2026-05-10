package services;
import entities.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

/**
 * SERVICE: MedicalRecordService
 * Goal: Manages all patient medical history data. */

public class MedicalRecordService {
    // Static list to store all medical records across the system
    private static final List<MedicalRecord> records = new ArrayList<>();

    // CREATE
    public void addRecord(MedicalRecord record) {
        records.add(record);
        System.out.println("LOG: Medical record [" + record.getRecordId() + "] created.");
    }

    // READ: Get records for a specific patient
    public List<MedicalRecord> getRecordsByPatientId(String patientId) {
        return records.stream()
                .filter(r -> r.getPatientId().equals(patientId))
                .toList();
    }

    // READ: Get records by a specific doctor
    public List<MedicalRecord> getRecordsByDoctorId(String doctorId) {
        return records.stream()
                .filter(r -> r.getDoctorId().equals(doctorId))
                .toList();
    }

    // READ: Display full patient history report
    public void displayPatientHistory(String patientId) {
        System.out.println("\n--- Clinical History for Patient: " + patientId + " ---");
        List<MedicalRecord> history = getRecordsByPatientId(patientId);
        if (history.isEmpty()) {
            System.out.println("No history records found.");
        } else {
            history.forEach(MedicalRecord::displayInfo);
        }
    }
}