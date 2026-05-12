package entities;

import java.time.LocalDate;

public class OutPatient extends Person {

    //The Constructor with Chaining avoid Error
    public OutPatient(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address) {
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
    }
}
