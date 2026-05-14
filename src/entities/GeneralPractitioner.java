package entities;

public class GeneralPractitioner extends Doctor {
    private static final double fee = 00;

    public GeneralPractitioner(String firstName, String lastName, String phoneNumber, String specialization) {
        // Sends exactly 4 arguments to the Doctor constructor above
        super(firstName, lastName, phoneNumber, specialization,fee);
    }
}