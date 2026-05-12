package entities;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor {

    //1. Add specific data
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
}
