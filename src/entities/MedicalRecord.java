package entities;

import java.time.LocalDate;

/**
 * ROLE: Stores diagnostic information for a patient visit.
 * CONCEPTS: Data Association (linking Patient and Doctor IDs).
 */
//Task 1.5: Create MedicalRecord Class
public class MedicalRecord {
    private String recordId;
    private String patientId;
    private String doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
    private String testResults;
    private String notes;

    public MedicalRecord(String recordId, String patientId, String doctorId, LocalDate visitDate,
                         String diagnosis, String prescription, String testResults, String notes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.testResults = testResults;
        this.notes = notes;
    }

    public void displayInfo() {
        System.out.println("--- Medical Record [" + recordId + "] ---");
        System.out.println("Date: " + visitDate);
        System.out.println("Patient ID: " + patientId);
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Prescription: " + prescription);
        System.out.println("Test Results: " + testResults);
        System.out.println("Notes: " + notes);
    }

    // Standard Getters and Setters
    public String getRecordId() { return recordId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
}