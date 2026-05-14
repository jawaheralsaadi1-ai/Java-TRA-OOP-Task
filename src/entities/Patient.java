package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * ROLE: Represents a Patient in the hospital.
 * CONCEPTS: Inheritance, Constructor Chaining, Method Overriding.
 */

public class Patient extends Person {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords; // Initially Strings for simplicity
    private List<String> appointments;   // Initially Strings



// Full Constructor using Constructor Chaining
    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String patientId, String bloodGroup, String emergencyContact, String insuranceId) {

        // Calling the parent (Person) constructor
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);

        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.emergencyContact = emergencyContact;
        this.registrationDate = LocalDate.now(); // Sets registration to today
        this.insuranceId = insuranceId;
        this.allergies = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
        this.appointments = new ArrayList<>();
    }
//Add no-arg constructor To void Error "Expected X arguments but found y"
    public Patient() {
        super(); // optional but better
        this.allergies = new ArrayList<>();
        this.medicalRecords = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.registrationDate = LocalDate.now();
    }

    // Overriding displayInfo() to include patient-specific details
    @Override
    public void displayInfo() {
        super.displayInfo(); // Display basic person info first
        System.out.println("--- Hospital Patient Details ---");
        System.out.println("Patient ID: " + patientId);
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Insurance ID: " + insuranceId);
        System.out.println("Registration Date: " + registrationDate);
        System.out.println("Emergency Contact: " + emergencyContact);
        System.out.println("Allergies: " + (allergies.isEmpty() ? "None" : allergies));
    }

    // Task Specific Methods
    public void addMedicalRecord(String record) {
        this.medicalRecords.add(record);
        System.out.println(" Medical record added for patient: " + getFirstName());
    }

    public void addAppointment(String appointment) {
        this.appointments.add(appointment);
    }

    public void updateInsurance(String newInsuranceId) {
        this.insuranceId = newInsuranceId;
        System.out.println(" Insurance updated for ID: " + patientId);
    }

    // Getters and Setters for Patient-specific fields
    public String getPatientId() { return patientId; }
    public String getBloodGroup() { return bloodGroup; }
    public List<String> getAllergies() { return allergies; }
    public void setAllergies(List<String> allergies) { this.allergies = allergies; }

    public void setBloodGroup(String bloodGroup) {
            this.bloodGroup = bloodGroup;
    }
}