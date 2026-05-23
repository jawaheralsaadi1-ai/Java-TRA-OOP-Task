package services;
import java.util.ArrayList;
import entities.Patient;
import java.util.*;

public class PatientService {

    // Internal storage for all patient types
    private static final List<Patient> patients = new ArrayList<>();


    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.getFirstName());
    }

    public Patient getPatientById(String patientId) {
        for (Patient p : patients) {
            if (p.getPatientId().equals(patientId)) {
                return p; // get it
            }
        }
        return null; // do not git it
    }

    //-------------- SECTION 1: OVERLOADED ADD METHODS ------------

    // 1. Minimal info quick add
    public void addPatient(String firstName, String lastName, String phone) {
        Patient newPatient;
        newPatient = new Patient(firstName, lastName, phone );
        patients.add(newPatient);
    }

    // 2. Medical details add
    public void addPatient(String firstName, String lastName, String phone, String bloodGroup, String email) {
        Patient p = new Patient(firstName, lastName, phone);
        p.setBloodGroup(bloodGroup);
        p.setEmail(email);
        addPatient(p);
    }


    //-------------- SECTION 2: CRUD OPERATIONS ------------

    public void removePatient(String patientId) {
        Patient patient = getPatientById(patientId);
        if (patient != null) {
            patients.remove(patient);
            System.out.println("Patient removed: " + patientId);
        } else {
            System.out.println("Patient not found: " + patientId);
        }
    }


    public void editPatient(String patientId, Patient updatedData) {
            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getPatientId().equals(patientId)) {
                    patients.set(i, updatedData);
                    System.out.println("Patient updated: " + patientId);
                    return;
                }
            }
            System.out.println("Patient not found: " + patientId);
        }

    //
    public void displayAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("===== All Patients =====");
        for (Patient p : patients) {
            p.displayInfo();
            System.out.println("------------------------");
        }
    }

    public List<Patient> searchPatientsByName(String name) {
        List<Patient> result = new ArrayList<>();
        for (Patient p : patients) {
            if (p.getFirstName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
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