package entities;

import java.time.LocalDateTime;

public class Appointment {
    private String notes;

    // Basic Note
    public void addNotes(String notes) {
        this.notes = notes;
    }

    // Note with Author
    public void addNotes(String notes, String addedBy) {
        this.notes = notes + " | Added by: " + addedBy;
    }

    // Full Audit Note
    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        this.notes = String.format("[%s] %s (Author: %s)", timestamp, notes, addedBy);
    }
}