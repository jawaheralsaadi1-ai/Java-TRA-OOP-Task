package entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor {

    //1. Add specific data ,
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;

    // 2. Updated Constructor
    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String doctorId, String specialization, String qualification,
                   int experienceYears, String departmentId, double consultationFee,
                   boolean operationTheatreAccess) {

        // Pass  mandatory identity data to the Doctor class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);

        // Initialize Surgeon-specific data
        this.surgeriesPerformed = 0; // Starts at zero
        this.surgeryTypes = new ArrayList<>();
        this.operationTheatreAccess = operationTheatreAccess;

}
    // 3.  Add specific data

    // Specialized Methods
    public void performSurgery(String surgeryType) {
        if (operationTheatreAccess) {
            this.surgeryTypes.add(surgeryType);
            this.surgeriesPerformed++;
            System.out.println("Surgery '" + surgeryType + "' performed successfully by Dr. " + getLastName());
        } else {
            System.out.println("Access Denied: Dr. " + getLastName() + " does not have Theatre Access.");
        }
    }
    public void updateSurgeryCount(int count) {
        if (count > 0) this.surgeriesPerformed += count;
}
    // Override displayInfo to show surgery details
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Surgeries Performed: " + surgeriesPerformed);
        System.out.println("Theatre Access: " + (operationTheatreAccess ? "Yes" : "No"));
    }
}
