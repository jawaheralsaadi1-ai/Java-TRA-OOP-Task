package entities;

public class Consultant extends Doctor {
    // Matches: new Consultant("DOC-2", "Sara", "Al-Said", "Neurology", 10)
    public Consultant(String id, String firstName, String lastName, String specialization, int experience) {
        super(id, firstName, lastName, specialization, experience);
    }

    @Override
    public void displayInfo() {
        System.out.print("[Consultant] ");
        super.displayInfo();
    }
}