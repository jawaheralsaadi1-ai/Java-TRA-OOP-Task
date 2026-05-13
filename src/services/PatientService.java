package services;
import entities.Patient;
import java.util.*;


// Create Service Classes with CRUD Operations
public class PatientService {

    // Internal storage for all patient types
    private static final List<Patient> patients = new ArrayList<>();

    //--------------SECTION 1: OVERLOADED ADD (REGISTRATION)------------
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
    //-------SECTION 3: OVERLOADED Display METHODS------------
    public void displayAllPatients() {}

    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Database is currently empty.");
            return;
        }
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    /** Display patients filtered by criteria r */
    public void displayPatients(String filter) {
        System.out.println("\n--- Filtered by: " + filter + " ---");
        for (Patient p : patients) {
            if (p.getBloodGroup().equalsIgnoreCase(filter) ||
                    p.getGender().equalsIgnoreCase(filter)) {
                p.displayInfo();
            }
        }
    }

    /** Display a specific number of records (limit) */
    public void displayPatients(int limit) {
        System.out.println("\n--- Showing top " + limit + " records ---");
        int count = 0;
        for (Patient p : patients) {
            if (count < limit) {
                p.displayInfo();
                count++;
            } else {
                break; // Stop loop once limit is reached
            }
        }
    }


    // 6. SEARCH
    //-------SECTION 2: OVERLOADED SEARCH METHODS------------
    // Search by name
    public void searchPatientsByName(String name) {}

    //Search by any field (Keyword search)
    public void searchPatients(String keyword ) {
        System.out.println("\n--- Results for: '" + keyword + "' ---");
        boolean found = false;
        for (Patient p : patients) {
            // Check if keyword exists in ID or Names
            if (p.getPatientId().contains(keyword) ||
                    p.getFirstName().contains(keyword) ||
                    p.getLastName().contains(keyword)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No matching records found.");

}
// Search by name
    public void searchPatients(String firstName, String lastName) {
        System.out.println("\n--- Results for: " + firstName + " " + lastName + " ---");
        boolean found = false;
        for (Patient p : patients) {
            // Compare names ignoring case sensitivity
            if (p.getFirstName().equalsIgnoreCase(firstName) &&
                    p.getLastName().equalsIgnoreCase(lastName)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No patient found with this name.");
    }
        }