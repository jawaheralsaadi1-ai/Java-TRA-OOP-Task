package entities;

import java.time.LocalDate;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;

    // Root Constructor
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        System.out.println("DEBUG: Level 1 - Person initialized.");
    }
}