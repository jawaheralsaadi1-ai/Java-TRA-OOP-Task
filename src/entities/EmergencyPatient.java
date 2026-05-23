package entities;

import java.time.LocalDate;
import java.util.List;

public class EmergencyPatient extends InPatient {
    private String emergencyType;
    private String arrivalMode; // Ambulance or Walk-in
    private int triageLevel;    // Priority scaling index value: 1 (urgent) to 5 (Non-Urgent)
    private boolean admittedViaER;

    /**
     * Constructor Chaining Flow:
     * Person -> Patient -> InPatient -> EmergencyPatient
     */
    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords, List<String> appointments, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges, String emergencyType, String arrivalMode, int triageLevel, boolean admittedViaER)
    {
        // Safe upstream delegation via super
/**/
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments, admissionDate, dischargeDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);
        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = admittedViaER;
    }
//    Overridden method
    @Override
    public void displayInfo() {
        System.out.print("[EMERGENCY] ");
        super.displayInfo();
    }
    //  Add specific data
    public String getEmergencyType() {
        return "";
    }

}