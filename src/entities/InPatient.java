package entities;

import java.time.LocalDate;
import java.time.LocalTime;

public class InPatient extends Patient{



//Override methods
//Add: calculateStayDuration(), calculateTotalCharges()*/
// Add specific  data
    private LocalDate admissionDate;
    private LocalTime dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    //Update Constructor Chaining
    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                     String gender, String phoneNumber, String email, String address,
                     String patientId, String bloodGroup, String emergencyContact, String insuranceId,
                     LocalDate admissionDate, LocalTime dischargeDate, String roomNumber, String bedNumber,
                     String admittingDoctorId, double dailyCharges)
    {
        // Pass mandatory identity data to the Patient class
        super(id, firstName, lastName, dateOfBirth, gender,
                phoneNumber, email, address, patientId, bloodGroup,
                emergencyContact, insuranceId);

        //Initialize specific data
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }
}
