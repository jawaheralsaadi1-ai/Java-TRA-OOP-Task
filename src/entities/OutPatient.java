
package entities;


import java.time.LocalDate;
import java.util.List;

class OutPatient extends Patient {
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    /**
     * Constructor Chaining Flow:
     * Person -> Patient -> OutPatient
     */
    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address,
                      String patientId, String bloodGroup, List<String> allergies, String emergencyContact, LocalDate registrationDate, String insuranceId,
                      List<String> medicalRecords, List<String> appointments, int visitCount, LocalDate lastVisitDate, String preferredDoctorId)
    // Safe upstream delegation via super

    {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, allergies, emergencyContact, registrationDate, insuranceId, medicalRecords, appointments);
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }
    // Overridden method incorporating consultation type delivery mechanisms
    public void displayInfo() {
        System.out.print("[OutPatient] ");
        super.displayInfo();
    }

    //   Add specific data
    public void scheduleFollowUp() {}

    public void updateVisitCount() {}


}