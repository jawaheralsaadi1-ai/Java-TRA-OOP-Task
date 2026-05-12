package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ROLE: Represents a Medical Professional (Doctor).
 * CONCEPTS: Constructor Chaining, List Management, Method Overriding.
 */
//Task 1.3: Create Doctor Class (extends Person)
public class Doctor extends Person {
    private String doctorId;
    private String specialization;
    private String qualification;
    private int experienceYears;
    private String departmentId;
    private double consultationFee;
    private List<String> availableSlots;
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

    // Task Specific Methods
    public void assignPatient(String patientId) {
        this.assignedPatients.add(patientId);
        System.out.println(" Patient " + patientId + " assigned to Dr. " + getLastName());
    }

    public void removePatient(String patientId) {
        this.assignedPatients.remove(patientId);
    }

    public void addAvailability(String slot) {
        this.availableSlots.add(slot);
    }

    // Getters and Setters
    public String getDoctorId() { return doctorId; }
    public String getSpecialization() { return specialization; }
}
