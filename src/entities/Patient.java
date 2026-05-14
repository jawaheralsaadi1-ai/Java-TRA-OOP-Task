package entities;

public class Patient extends Person {
    private String email;
    private String address;

    // Constructor Chaining (Task 2.4)
    public Patient(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }

    // --- Task 2.5: Method Overloading ---

    // Level 1: Base update
    public void updateContact(String phone) {
        this.phoneNumber = phone;
    }

    // Level 2: Calls Level 1
    public void updateContact(String phone, String email) {
        this.updateContact(phone);
        this.email = email;
    }

    // Level 3: Calls Level 2
    public void updateContact(String phone, String email, String address) {
        this.updateContact(phone, email);
        this.address = address;
    }
}