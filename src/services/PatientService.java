package services;
import entities.Patient;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * ROLE: Logic engine for Patient management.
 * CONCEPTS: CRUD Operations, Data Search, List Filtering.
 */
//Task 1.8: Create Service Classes with CRUD Operations
public class PatientService {
    // In-memory database for patients
    private static final List<Patient> patients = new ArrayList<>();

    // 1. CREATE: Add a new patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println(" Patient [" + patient.getFirstName() + "] registered successfully.");
    }
    // 2. UPDATE: Edit existing patient
    public void editPatient(String patientId, Patient updatedData) {
        Patient existing = getPatientById(patientId);
        if (existing != null) {
            existing.setFirstName(updatedData.getFirstName());
            existing.setLastName(updatedData.getLastName());
            existing.setPhoneNumber(updatedData.getPhoneNumber());
            existing.setEmail(updatedData.getEmail());
            existing.setAddress(updatedData.getAddress());
            existing.setAllergies(updatedData.getAllergies());
            System.out.println(" Patient record updated for ID: " + patientId);
        } else {
            System.out.println("Error: Patient with ID " + patientId + " not found.");
        }
    }


    // 3. READ: Get patient by ID
    public Patient getPatientById(String patientId) {
        return patients.stream()
                .filter(p -> p.getPatientId().equals(patientId))
                .findFirst()
                .orElse(null);
    }
    // 4. DELETE: Remove patient
    public void removePatient(String patientId) {
        boolean removed = patients.removeIf(p -> p.getPatientId().equals(patientId));
        if (removed) {
            System.out.println(" Patient with ID " + patientId + " removed from system.");
        } else {
            System.out.println(" Error: Could not find patient to remove.");
        }
    }

    // 5. READ: Display all patients
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println(" No patients registered in the system.");
            return;
        }
        System.out.println("\n--- Registered Patients List ---");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("--------------------------------");
        }
    }


    // 6. SEARCH: Search by Name
    public void searchPatientsByName(String name) {
        System.out.println("Search results for: " + name);
        patients.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name))
                .forEach(Patient::displayInfo);
    }
}