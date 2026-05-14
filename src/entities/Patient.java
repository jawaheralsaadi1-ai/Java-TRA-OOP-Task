package entities;

import java.time.LocalDate;

public class Patient extends Person {
    protected String patientId;
    protected LocalDate registrationDate;

    public Patient(String firstName, String lastName, String phoneNumber, String patientId) {
        // CHAINING: Calling the Person(String, String, String) constructor
        super(firstName, lastName, phoneNumber);
        this.patientId = patientId;
        this.registrationDate = LocalDate.now();
        System.out.println("DEBUG: Level 2 - Patient initialized.");
    }
}