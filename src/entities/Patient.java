package entities;

public class Patient extends Person {
    private String patientId;
    private String bloodGroup;

    // Fixed Constructor: Matches the 4 arguments usually needed
    public Patient(String firstName, String lastName, String phoneNumber, String patientId) {
        super(firstName, lastName, phoneNumber);
        this.patientId = patientId;
    }

    // Getters and Setters
    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }
}