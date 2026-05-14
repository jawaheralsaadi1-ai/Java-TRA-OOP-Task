package entities;

public class InPatient extends Patient {
    protected String roomNumber;
    protected double dailyCharges;

    public InPatient(String firstName, String lastName, String phoneNumber,
                     String patientId, String roomNumber, double dailyCharges) {
        // CHAINING: Calling the Patient(...) constructor
        super(firstName, lastName, phoneNumber, patientId);
        this.roomNumber = roomNumber;
        this.dailyCharges = dailyCharges;
        System.out.println("DEBUG: Level 3 - InPatient initialized.");
    }
}