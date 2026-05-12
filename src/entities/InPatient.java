package entities;

import java.time.LocalDate;

public class InPatient extends Patient{

    //The Constructor with Chaining avoid Error
    public InPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address, String patientId, String bloodGroup, String emergencyContact, String insuranceId) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, patientId, bloodGroup, emergencyContact, insuranceId);
    }
}
