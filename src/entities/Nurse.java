package entities;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * ROLE: Represents a Nursing Professional.
 * CONCEPTS: Constructor Chaining, Encapsulation, Patient Assignment.
 */
// Task 1.4: Create Nurse Class (extends Person)
public class Nurse extends Person {
    private String nurseId;
    private String departmentId;
    private String shift; // e.g., Morning, Evening, Night
    private String qualification;
    private List<String> assignedPatients;

    public Nurse(String id, String firstName, String lastName, LocalDate dateOfBirth,
                 String gender, String phoneNumber, String email, String address,
                 String nurseId, String departmentId, String shift, String qualification) {

        // Constructor Chaining to the Person base class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);

        this.nurseId = nurseId;
        this.departmentId = departmentId;
        this.shift = shift;
        this.qualification = qualification;
        this.assignedPatients = new ArrayList<>();
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Display basic person details
        System.out.println("--- Nursing Professional Details ---");
        System.out.println("Nurse ID: " + nurseId);
        System.out.println("Department: " + departmentId);
        System.out.println("Current Shift: " + shift);
        System.out.println("Qualification: " + qualification);
        System.out.println("Assigned Patients: " + assignedPatients.size());
    }

    // Task Specific Methods
    public void assignPatient(String patientId) {
        this.assignedPatients.add(patientId);
        System.out.println("👩‍⚕️ Patient " + patientId + " assigned to Nurse " + getLastName());
    }

    public void removePatient(String patientId) {
        this.assignedPatients.remove(patientId);
    }

    // Getters and Setters
    public String getNurseId() { return nurseId; }
    public String getDepartmentId() { return departmentId; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}