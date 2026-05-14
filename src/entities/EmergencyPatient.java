package entities;

public class EmergencyPatient extends InPatient {
    private int triageLevel;
    private String emergencyType;

    public EmergencyPatient(String firstName, String lastName, String phoneNumber,
                            String patientId, String roomNumber, double dailyCharges,
                            int triageLevel, String emergencyType) {

        // CHAINING: Calling the InPatient(...) constructor
        // This single call triggers the entire chain back to Person
        super(firstName, lastName, phoneNumber, patientId, roomNumber, dailyCharges);

        this.triageLevel = triageLevel;
        this.emergencyType = emergencyType;
        System.out.println("DEBUG: Level 4 - EmergencyPatient fully initialized.");
    }
}