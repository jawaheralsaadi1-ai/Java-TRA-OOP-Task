package entities;

public class EmergencyPatient extends InPatient {
    private String triageLevel;
    private int severity;

    // Matches: new EmergencyPatient("PAT-2", "Amna", "Al-Farsi", "High", 1)
    public EmergencyPatient(String id, String firstName, String lastName, String triageLevel, int severity) {
        super(id, firstName, lastName, "ER-WARD", 0.0);
        this.triageLevel = triageLevel;
        this.severity = severity;
    }

    @Override
    public void displayInfo() {
        System.out.print("[EMERGENCY] ");
        super.displayInfo();
        System.out.println("Triage Level: " + triageLevel + " | Severity: " + severity);
    }
}