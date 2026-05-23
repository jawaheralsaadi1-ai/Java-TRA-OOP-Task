package entities;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 * ROLE: Represents a Medical Professional (Doctor).
 * CONCEPTS: Constructor Chaining, List Management, Method Overriding.
 */
public class Doctor extends Person implements Displayable {

    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    protected List<String> availableSlots;
    private List<String> assignedPatients;

    public Doctor(String id, String firstName, String lastName, LocalDate dateOfBirth,
                  String gender, String phoneNumber, String email, String address,
                  String doctorId, String specialization, String qualification,
                  int experienceYears, String departmentId, double consultationFee) {

        // Constructor Chaining to Person
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);

        this.doctorId = doctorId;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experienceYears = experienceYears;
        this.departmentId = departmentId;
        this.consultationFee = consultationFee;
        this.availableSlots = new ArrayList<>();
        this.assignedPatients = new ArrayList<>();
    }

    public Doctor(String name, String firstName, String phone, String specialization, double fee) {
        super();
    }


    @Override
    public void displayInfo() {
        super.displayInfo(); // Displays Person details
        System.out.println("--- Medical Professional Details ---");
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Specialization: " + specialization);
        System.out.println("Qualification: " + qualification);
        System.out.println("Experience: " + experienceYears + " years");
        System.out.println("Consultation Fee: $" + consultationFee);
        System.out.println("Department: " + departmentId);
    }

    //  Specific Methods
    public void assignPatient(String patientId) {}
    //this.assignedPatients.add(patientId);
    // System.out.println("️ Patient " + patientId + " assigned to Dr. " + getLastName());


    public void removePatient(String patientId) {}
    // this.assignedPatients.remove(patientId);


    public void updateAvailability(String slot) {}
    //this.availableSlots.add(slot);


    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public boolean setAvailableSlots() {
        this.availableSlots = availableSlots;
        return false;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }
    // Method Overloading - updateFee
    public void updateFee(double fee) {
        this.setConsultationFee(fee);
        System.out.println("Fee updated: " + fee);
    }

    public void updateFee(double fee, String reason) {
        this.setConsultationFee(fee);
        System.out.println("Fee updated: " + fee + " | Reason: " + reason);
    }

    // Method Overloading - addAvailability
    public void addAvailability(String slot) {
        this.availableSlots.add(slot);
        System.out.println("Slot added: " + slot);
    }

    public void addAvailability(List<String> slots) {
        this.availableSlots.addAll(slots);
        System.out.println("Slots added: " + slots.size());
    }
    @Override
    public void displaySummary() {
        System.out.println("Doctor: " + getFirstName() + " " + getLastName() +
                " | Specialization: " + getSpecialization() +
                " | Fee: $" + getConsultationFee());
    }
}