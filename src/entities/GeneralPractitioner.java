package entities;

import java.lang.reflect.Constructor;
import java.time.LocalDate;
import java.util.concurrent.Flow;

public class GeneralPractitioner extends Doctor {
    private boolean walkinAvailable;
    private boolean homeVisitAvailable;
    private boolean vaccinationCertified;

    /**
     * Constructor Chaining Flow:
     * Person -> Doctor -> GeneralPractitioner
     */
    public GeneralPractitioner(String id, String firstName, String lastName, LocalDate dateOfBirth,
                               String gender, String phoneNumber, String email, String address, String doctorId, String specialization, String qualification,
                               int experienceYears, String departmentId, double consultationFee, boolean walkinAvailable, boolean homeVisitAvailable, boolean vaccinationCertified) {// Enforces "General Practice" as a rigid standard specialization type parameter
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.walkinAvailable = walkinAvailable;
        this.homeVisitAvailable = homeVisitAvailable;
        this.vaccinationCertified = vaccinationCertified;

    }

    // Overridden method
    @Override
    public void displayInfo() {
        System.out.print("[GeneralPractitioner] ");
        super.displayInfo();
    }
    //   Add specific data
    public void scheduleHomeVisit() {}
    public void administerVaccine(){}
}