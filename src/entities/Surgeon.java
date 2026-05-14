package entities;

public class Surgeon extends Doctor {
    // Matches: new Surgeon("DOC-1", "Ahmed", "Al-Balushi", "General Surgery", 15)
    public Surgeon(String id, String firstName, String lastName, String specialization, int experience) {
        super(id, firstName, lastName, specialization, experience);
    }

    @Override
    public void displayInfo() {
        System.out.print("[Surgeon] ");
        super.displayInfo();
    }
}