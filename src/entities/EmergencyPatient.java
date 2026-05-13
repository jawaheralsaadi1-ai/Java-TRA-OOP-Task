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
    private String arrivalMode;
    private int triageLevel;
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
        this.admittedViaER = admittedViaER;
    }
}
