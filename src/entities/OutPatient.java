package entities;

import java.time.LocalDate;

/*
   1.Additional fields :
     -visitCount (int)
     -lastVisitDate (LocalDate)
     -preferredDoctorId (String)
  2. Add Override methods
  3. Add methods :  scheduleFollowUp(), updateVisitCount()*/

public class OutPatient extends Person {
    // Declaring  specific data
    private int visitCount;
    private LocalDate lastVisitDate;
    private String preferredDoctorId;

    // Update Constructor Chaining
    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth,
                      String gender, String phoneNumber, String email, String address,
                      int visitCount, LocalDate lastVisitDate, String preferredDoctorId) {
        // Pass mandatory identity data to the Patient class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);

        // Initialize specific data
        this.visitCount = visitCount;
        this.lastVisitDate = lastVisitDate;
        this.preferredDoctorId = preferredDoctorId;
    }
}