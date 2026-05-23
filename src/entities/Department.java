package entities;

import interfaces.Displayable;

import java.util.ArrayList;
import java.util.List;


//Create Department Class
public class Department implements Displayable {
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

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getHeadDoctorId() {
        return headDoctorId;
    }

    public void setHeadDoctorId(String headDoctorId) {
        this.headDoctorId = headDoctorId;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(List<Nurse> nurses) {
        this.nurses = nurses;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public int getAvailableBeds() {
        return availableBeds;
    }

    public void setAvailableBeds(int availableBeds) {
        this.availableBeds = availableBeds;
    }

    @Override
    public void displaySummary() {
        System.out.println("Department: " + departmentName +
                " | Beds: " + availableBeds + "/" + bedCapacity);
    }
}