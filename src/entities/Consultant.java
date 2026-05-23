package entities;

import java.time.LocalDate;
import java.util.List;

public class Consultant extends Doctor {

    private List<String> consultationTypes;
    private boolean onlineConsultationAvailable;
    private int consultationDuration; // defined in minutes

    /**
     * Constructor Chaining Flow:
     * Person -> Doctor -> Consultant
     */

    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth,
                      String gender, String phoneNumber, String email, String address, String doctorId,
                      String specialization, String qualification, int experienceYears, String departmentId,
                      double consultationFee, List<String> consultationTypes, boolean onlineConsultationAvailable, int consultationDuration)
    {
        // Safely chains initialization parameters back to structural base classes
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.consultationTypes = consultationTypes;
        this.onlineConsultationAvailable = onlineConsultationAvailable;
        this.consultationDuration = consultationDuration;
    }


    // Overridden method incorporating consultation type delivery mechanisms
    @Override
    public void displayInfo() {
        System.out.print("[Consultant] ");
        super.displayInfo();
    }
    //   Add specific data
    public void scheduleConsultation() {}
    public void provideSecondOpinion() {}

    public List<String> getConsultationTypes() {
        return consultationTypes;
    }

    public void setConsultationTypes(List<String> consultationTypes) {
        this.consultationTypes = consultationTypes;
    }

    public boolean isOnlineConsultationAvailable() {
        return onlineConsultationAvailable;
    }

    public void setOnlineConsultationAvailable(boolean onlineConsultationAvailable) {
        this.onlineConsultationAvailable = onlineConsultationAvailable;
    }

    public int getConsultationDuration() {
        return consultationDuration;
    }

    public void setConsultationDuration(int consultationDuration) {
        this.consultationDuration = consultationDuration;
    }
}