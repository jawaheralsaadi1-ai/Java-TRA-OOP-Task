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
        addPatient(firstName, lastName, phone, "Unknown", "N/A");    }

    // 2. Medical details add (Extra details).
    public void addPatient(String firstName, String lastName,
                           String phone, String bloodGroup, String email) {
        Patient patient = new Patient();
        patient.setFirstName(firstName);
        patient.setLastName(lastName);
        patient.setPhoneNumber(phone);
        patient.setBloodGroup(bloodGroup);
        patient.setEmail(email);

        addPatient(patient);    }
    // 3. Full object add  Standard).
    public static void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
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
    //Display all patients
    public void displayPatients() {
        if (patients.isEmpty()) {
            System.out.println("Database is currently empty.");
            return;
        }
        System.out.println("\n--- All Patients ---");

        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    //Display patients (String filter)
    public void displayPatients(String filter) {
        System.out.println("\n--- Filtered by: " + filter + " ---");
        boolean found = false;

        for (Patient patient : patients) {
            if (
                    (patient.getBloodGroup() != null && patient.getBloodGroup().equalsIgnoreCase(filter)) ||
                            (patient.getGender() != null && patient.getGender().equalsIgnoreCase(filter))
            ) {
                patient.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients match this filter.");
        }
    }
    // Display a specific number of records (limit)
    public void displayPatients(int limit) {
        System.out.println("\n--- Showing top " + limit + " records ---");
        if (patients.isEmpty()) {
            System.out.println("No patients available.");
            return;
        }
        int count = 0;
        for (Patient patient : patients) {
            if (count < limit) {
                patient.displayInfo();
                count++;
            } else {
                break; // Stop loop once limit is reached
            }
        }
        if (count == 0) {
            System.out.println("No patients to display.");
        }
    }

    // 6. SEARCH
    //-------SECTION 2: OVERLOADED SEARCH METHODS------------
    // Search by name
    public void searchPatientsByName(String name) {}

    //Search by any field (Keyword search)
    public void searchPatients(String keyword ) {
        boolean found = false;
        for (Patient patient: patients) {
            // Check if keyword exists in ID or Names
            if(
            (patient.getPatientId() != null && patient.getPatientId().contains(keyword)) ||
             (patient.getFirstName() != null && patient.getFirstName().contains(keyword))||
                     (patient.getBloodGroup() != null && patient.getBloodGroup().equalsIgnoreCase(keyword))||
                     (patient.getEmail() != null && patient.getEmail().contains(keyword)))
            {
            patient.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No matching records found.");


}
// Search by name
    public void searchPatients(String firstName, String lastName) {
        System.out.println("\n--- Results for: " + firstName + " " + lastName + " ---");
        boolean found = false;
        for (Patient patient : patients) {
            // Compare names ignoring case sensitivity
            if (
                    patient.getFirstName().equalsIgnoreCase(firstName) &&
                    patient.getLastName().equalsIgnoreCase(lastName)
            ) {
                patient.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No patient found with this name.");
    }
        }
