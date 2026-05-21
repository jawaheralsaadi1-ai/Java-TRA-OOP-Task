package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Surgeon extends Doctor {

    //Add specific data
    private int surgeriesPerformed;
    private List<String> surgeryTypes;
    private boolean operationTheatreAccess;


    //  Constructor
    public Surgeon(String id, String firstName, String lastName, LocalDate dateOfBirth,
                   String gender, String phoneNumber, String email, String address,
                   String doctorId, String specialization, String qualification,
                   int experienceYears, String departmentId, double consultationFee,
                   boolean operationTheatreAccess) {

// Chains up to the Doctor constructor (and by extension, the Person constructor)
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);        this.surgeryTypes = new ArrayList<>();
        this.operationTheatreAccess = operationTheatreAccess;
        this.surgeryTypes.add(id);
        this.surgeryTypes.add(firstName);

    }

    // Override methods
    public String getSpecialisation() {
        return "Surgical Services - " + super.getSpecialization();
    }


//   Add specific data

    // Specialized Methods
    public void performSurgery(String surgeryType) {

    }

    public void updateSurgeryCount(int count) {}


    public int getSurgeriesPerformed() {
        return surgeriesPerformed;
    }

    public void setSurgeriesPerformed(int surgeriesPerformed) {
        this.surgeriesPerformed = surgeriesPerformed;
    }

    public List<String> getSurgeryTypes() {
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<String> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public boolean isOperationTheatreAccess() {
        return operationTheatreAccess;
    }

    public void setOperationTheatreAccess(boolean operationTheatreAccess) {
        this.operationTheatreAccess = operationTheatreAccess;
    }
}
