package services;

import entities.Patient;
import java.util.*;

public class PatientService {

    // Internal storage for all patient types
    private static final List<Patient> patients = new ArrayList<>();

    //-------------- SECTION 1: OVERLOADED ADD METHODS ------------

    // 1. Minimal info quick add
    public void addPatient(String firstName, String lastName, String phone) {
        // Generates a temporary ID and calls the standard add
        Patient p = new Patient(firstName, lastName, phone, "TEMP-" + System.currentTimeMillis());
        addPatient(p);
    }

    // 2. Medical details add
    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient p = new Patient(firstName, lastName, phone, "PAT-" + (patients.size() + 1));
        p.setBloodGroup(bloodGroup);
        p.setEmail(email);
        addPatient(p);
    }

    // 3. Standard add using full object (Removed static to fix the 'Instance Reference' warning)
    public void addPatient(Patient patient) {
        if (patient != null) {
            patients.add(patient);
        }
    }

    //-------------- SECTION 2: CRUD OPERATIONS ------------

    public Patient getPatientById(String patientId) {
        return patients.stream()
                .filter(p -> p.getPatientId() != null && p.getPatientId().equalsIgnoreCase(patientId))
                .findFirst()
                .orElse(null);
    }

    public void removePatient(String patientId) {
        boolean removed = patients.removeIf(p -> p.getPatientId().equalsIgnoreCase(patientId));
        if (removed) {
            System.out.println("Patient removed successfully.");
        } else {
            System.out.println("Patient ID not found.");
        }
    }

    public void editPatient(String patientId, Patient updatedData) {
        Patient existing = getPatientById(patientId);
        if (existing != null && updatedData != null) {
            existing.setFirstName(updatedData.getFirstName());
            existing.setLastName(updatedData.getLastName());
            existing.setPhoneNumber(updatedData.getPhoneNumber());
            System.out.println("Patient updated successfully.");
        }
    }

    // Used by Main App for stats and list counts
    public List<Patient> getAll() {
        return patients;
    }

    //-------------- SECTION 3: OVERLOADED DISPLAY & SEARCH ------------

    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("\n--- Patient Database ---");
        for (Patient p : patients) {
            p.displayInfo(); // Polymorphism: Works for Patient, InPatient, and EmergencyPatient
            System.out.println("-------------------------");
        }
    }

    public void searchPatientsByName(String name) {
        System.out.println("\n--- Searching for: " + name + " ---");
        boolean found = false;
        for (Patient p : patients) {
            if (p.getFirstName().equalsIgnoreCase(name) || p.getLastName().equalsIgnoreCase(name)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No records found matching that name.");
    }

    public void searchPatients(String keyword) {
        boolean found = false;
        for (Patient p : patients) {
            if (p.getFirstName().contains(keyword) || p.getPatientId().contains(keyword)) {
                p.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No matching records for: " + keyword);
    }
}