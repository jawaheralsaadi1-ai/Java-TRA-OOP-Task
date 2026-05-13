package services;
import entities.Patient;
import java.util.*;


// Create Service Classes with CRUD Operations
public class PatientService {

    // Internal storage for all patient types
    private static final List<Patient> patients = new ArrayList<>();

    //SECTION 1: OVERLOADED REGISTRATION
    // 1. Minimal info for quick add.
    public void addPatient(String firstName, String lastName, String phone) {
        System.out.println("Quick Add: Registering " + firstName + " " + lastName + " with phone: " + phone);
    }

    // 2. Medical details add (Extra details).
    public void addPatient(String firstName, String lastName,
                           String phone, String bloodGroup, String email) {
        System.out.println("Medical Add: Registering " + firstName + " [Blood Group: " + bloodGroup + "]");
    }
    // 3. Full object add  (Standard).
    public static void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
            System.out.println("Full Object Success: Added Patient ID " + patient.getPatientId());
        }
    }

    // 2. UPDATE: Edit existing patient
    public void editPatient(String patientId, Patient updatedData) {
        Patient existing = getPatientById(patientId);
    }

    // 3. READ: Get patient by ID
    public Patient getPatientById(String patientId) {
        return patients.stream()
                .filter(p -> p.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);
    }
    // 4. DELETE: Remove patient
    public void removePatient(String patientId) {}

    // 5. READ: Display all patients
    public void displayAllPatients() {}

    // 6. SEARCH: Search by Name
    public void searchPatientsByName(String name) {}


}