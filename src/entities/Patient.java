package entities;

import interfaces.Displayable;

import java.time.LocalDate;
import java.util.List;


//Create Base  Class and Inheritance Hierarchy
public class Patient extends Person implements Displayable {
    private String patientId;
    private String bloodGroup;
    private List<String> allergies;
    private String emergencyContact;
    private LocalDate registrationDate;
    private String insuranceId;
    private List<String> medicalRecords;
    private List<String> appointments;

    // Full Constructor using Constructor Chaining

    public Patient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup,
                   List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords,
                   List<String> appointments) {
        //// Constructor Chaining Stage 1: Call Person
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
        this.patientId = patientId;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.emergencyContact = emergencyContact;
        this.registrationDate = registrationDate;
        this.insuranceId = insuranceId;
        this.medicalRecords = medicalRecords;
        this.appointments = appointments;
    }

    public Patient(String firstName, String lastName, String phone) {
    }


    // Overriding displayInfo() to include patient-specific details
    @Override
    public void displayInfo() {
        System.out.println("--- Patient Medical Profile ---");
        super.displayInfo();// Display basic person info first
        System.out.println("Blood Group: " + bloodGroup);
        System.out.println("Insurance ID: " + insuranceId);
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<String> getAllergies() {
        return allergies;
    }

    public void setAllergies(List<String> allergies) {
        this.allergies = allergies;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(String insuranceId) {
        this.insuranceId = insuranceId;
    }

    public List<String> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<String> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    public List<String> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<String> appointments) {
        this.appointments = appointments;
    }

    // Method Overloading - updateContact
    public void updateContact(String phone) {
        this.setPhoneNumber(phone);
        System.out.println("Phone updated: " + phone);
    }

    public void updateContact(String phone, String email) {
        this.setPhoneNumber(phone);
        this.setEmail(email);
        System.out.println("Phone and email updated.");
    }

    public void updateContact(String phone, String email, String address) {
        this.setPhoneNumber(phone);
        this.setEmail(email);
        this.setAddress(address);
        System.out.println("Contact info fully updated.");
    }

    @Override
    public void displaySummary() {
        System.out.println("Patient: " + getFirstName() + " " + getLastName() +
                " | Blood Group: " + getBloodGroup() +
                " | Insurance: " + getInsuranceId());
    }
}

