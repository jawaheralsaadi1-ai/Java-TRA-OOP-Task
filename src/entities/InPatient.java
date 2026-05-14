package entities;

public class InPatient extends Patient {
    private String roomNumber;
    private double dailyCharges;

    // Matches: new InPatient("PAT-1", "John", "Doe", "Room 302", 150.0)
    public InPatient(String id, String firstName, String lastName, String roomNumber, double dailyCharges) {
        super(firstName, lastName, "N/A", id); // Mapping to Patient(fname, lname, phone, id)
        this.roomNumber = roomNumber;
        this.dailyCharges = dailyCharges;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Room: " + roomNumber + " | Daily Rate: " + dailyCharges + " OMR");
    }
}