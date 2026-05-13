package entities;
import java.time.LocalDate;



/*GeneralPractitioner Class (extends Doctor)
• Additional fields:
o walkinAvailable (boolean)
o homeVisitAvailable (boolean)
o vaccinationCertified (boolean)
• Override methods
• Add: scheduleHomeVisit(), administerVaccine()*/

//Task 2.1: Specialized Doctor Type - General Practitioner (GP)
public class GeneralPractitioner extends Doctor {

    // 1. Declaring specific data
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    //2. Update Constructor Person -> Doctor -> GeneralPractitioner
    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth,
                               String gender, String phoneNumber, String email, String address,
                               String doctorId, String specialization, String qualification,
                               int experienceYears, String departmentId, double consultationFee,
                               boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified)
    {
        // Pass mandatory identity data to the Doctor class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address,
                doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        //Initialize specific data
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = true;
    }

    // 3. Add Specialized Methods
    // Add scheduleHomeVisit()
    public void scheduleHomeVisit(){
        if (homeVisitAvailable) {
            System.out.println("[ [GP] Home visit scheduled successfully.");
        } else {
            System.out.println(" [GP] Home visits are not available for this doctor.");
        }
    }
    // Add administerVaccine()
    public void administerVaccine(){
        if (vaccinationCertified) {
            System.out.println("[GP] Vaccine Administering successfully");
        } else {
            System.out.println("[GP] Doctor is not certified to administer vaccines.");
        }
    }


@Override
public void displayInfo() {
    // First, call the Doctor's displayInfo to show basic info
    super.displayInfo();
    // Then, add GP-specific info
    System.out.println("Walk-in Available: " + walkinAvailable);
    System.out.println("Home Visit Available: " + homeVisitAvailable);
    System.out.println("Vaccination Certified: " + vaccinationCertified);
}
}
