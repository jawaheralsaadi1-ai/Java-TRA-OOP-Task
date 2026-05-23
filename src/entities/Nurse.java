package entities;
import interfaces.Displayable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//  Create Nurse Class (extends Person)
public class Nurse extends Person implements Displayable {
    private String nurseId;
    private String departmentId;
    private String shift; //  Morning/Evening/Night
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

    //  Specific Methods
    public void assignPatient(String patientId) {
        this.assignedPatients.add(patientId);}
    //  System.out.println("Patient " + patientId + " assigned to Nurse " + getLastName());


    public void removePatient(String patientId) {
        this.assignedPatients.remove(patientId);
    }

    // Getters and Setters

    public String getNurseId() {
        return nurseId;
    }

    public void setNurseId(String nurseId) {
        this.nurseId = nurseId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public List<String> getAssignedPatients() {
        return assignedPatients;
    }

    public void setAssignedPatients(List<String> assignedPatients) {
        this.assignedPatients = assignedPatients;
    }

        @Override
        public void displaySummary() {
            System.out.println("Nurse: " + getFirstName() + " " + getLastName() +
                    " | Shift: " + getShift() +
                    " | Department: " + getDepartmentId());
        }
}