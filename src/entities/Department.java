package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * ROLE: Represents a Hospital Department (e.g., Cardiology).
 * CONCEPTS: Aggregation, Resource Management (Beds).
 */
//Task 1.7: Create Department Class
public class Department {
    private String departmentId;
    private String departmentName;
    private String headDoctorId;
    private List<Doctor> doctors;
    private List<Nurse> nurses;
    private int bedCapacity;
    private int availableBeds;

    public Department(String departmentId, String departmentName, int bedCapacity) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.bedCapacity = bedCapacity;
        this.availableBeds = bedCapacity; // Initially all beds are available
        this.doctors = new ArrayList<>();
        this.nurses = new ArrayList<>();
    }

    // Task Specific Methods
    public void assignDoctor(Doctor doctor) {
        this.doctors.add(doctor);
        System.out.println("🩺 Dr. " + doctor.getLastName() + " assigned to " + departmentName);
    }

    public void assignNurse(Nurse nurse) {
        this.nurses.add(nurse);
        System.out.println(" Nurse " + nurse.getLastName() + " assigned to " + departmentName);
    }

    public void updateBedAvailability(int occupiedBeds) {
        if (occupiedBeds <= bedCapacity) {
            this.availableBeds = bedCapacity - occupiedBeds;
        } else {
            System.out.println(" Error: Occupied beds exceed capacity!");
        }
    }

    public void displayInfo() {
        System.out.println("--- Department: " + departmentName + " [" + departmentId + "] ---");
        System.out.println("Head Doctor ID: " + (headDoctorId != null ? headDoctorId : "Not Assigned"));
        System.out.println("Staff Count: Doctors (" + doctors.size() + "), Nurses (" + nurses.size() + ")");
        System.out.println("Bed Status: " + availableBeds + "/" + bedCapacity + " available");
    }

    // Getters and Setters
    public String getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }
    public void setHeadDoctorId(String headDoctorId) { this.headDoctorId = headDoctorId; }
}