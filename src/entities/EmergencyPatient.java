package entities;

/*EmergencyPatient Class (extends InPatient)
• Additional fields for EmergencyPatient (EP) :
o emergencyType (String)
o arrivalMode (String - Ambulance/Walk-in)
o triageLevel (int - 1 to 5)
o admittedViaER (boolean)
• Override methods with emergency-specific logic*/

import java.time.LocalDate;
import java.time.LocalTime;

public class EmergencyPatient extends InPatient {

    // Declaring specific data for EmergencyPatient (EP)
    private String emergencyType;
    private String arrivalMode; // Ambulance or Walk-in
    private int triageLevel; // 1 (Urgent) to 5 (Non-urgent)
    private boolean admittedViaER;

    // Setup Constructor
    public EmergencyPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                            String gender, String phoneNumber, String email, String address,
                            String patientId, String bloodGroup, String emergencyContact,
                            String insuranceId, LocalDate admissionDate, LocalTime dischargeDate,
                            String roomNumber, String bedNumber, String admittingDoctorId,
                            double dailyCharges, String emergencyType, String arrivalMode,
                            int triageLevel, boolean admittedViaER)

    {
        // Pass data to InPatient
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, emergencyContact, insuranceId, admissionDate, dischargeDate, roomNumber, bedNumber, admittingDoctorId, dailyCharges);

        //Initialize specific data
        this.emergencyType = emergencyType;
        this.arrivalMode = arrivalMode;
        this.triageLevel = triageLevel;
        this.admittedViaER = true;
    }

    // implement Override displayInfo
    @Override
    public void displayInfo() {
        System.out.println("--- EMERGENCY CASE ---");
        // This will print Person, Patient, and InPatient info
        super.displayInfo();
        System.out.println("Emergency Type: " + emergencyType);
        System.out.println("Arrival Mode: " + arrivalMode);
        System.out.println("Triage Level: " + triageLevel + " (Priority)");

    }

    //  Implement Specialized Methods with logic
    public void updateTriageLevel(int newLevel) {
    if (newLevel >=1 && newLevel <= 5) {
        this.triageLevel = newLevel;
        System.out.println("Triage level updated to:" + newLevel + "for patient: "+ getFirstName() + " " + getLastName());
    }
    }

}



