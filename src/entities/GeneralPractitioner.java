package entities;
import java.time.LocalDate;



/*GeneralPractitioner Class (extends Doctor)
• Additional fields:
o walkinAvailable (boolean)
o homeVisitAvailable (boolean)
o vaccinationCertified (boolean)
• Override methods
• Add: scheduleHomeVisit(), administerVaccine()*/

public class GeneralPractitioner extends Doctor {
    // 1. Declaring specific data
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    //2. Update Constructor
    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth,
                               String gender, String phoneNumber, String email, String address,
                               String doctorId, String specialization, String qualification,
                               int experienceYears, String departmentId, double consultationFee,
                               boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified)
    {
        // Pass mandatory identity data to the Doctor class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;
    }
}
