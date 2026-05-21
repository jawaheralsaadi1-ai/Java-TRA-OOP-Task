package entities;

import java.time.LocalDate;
import java.util.List;

public class InPatient extends Patient {
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private String roomNumber;
    private String bedNumber;
    private String admittingDoctorId;
    private double dailyCharges;

    /**
     * Constructor Chaining Flow:
     * Person -> Patient -> InPatient
     */
    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                     String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup,
                     List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId, List<String> medicalRecords,
                     List<String> appointments, LocalDate admissionDate, LocalDate dischargeDate, String roomNumber, String bedNumber, String admittingDoctorId, double dailyCharges)

    // Safe upstream delegation via super
    {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.roomNumber = roomNumber;
        this.bedNumber = bedNumber;
        this.admittingDoctorId = admittingDoctorId;
        this.dailyCharges = dailyCharges;
    }

    // Overridden method
    public void displayInfo() {
        System.out.print("[InPatient] ");
        super.displayInfo();
    }

    //   Add specific data
    public long calculateStayDuration(){
        return 0;
    }
    public double calculateTotalCharges() {
        return 0;
    }
}
