package entities;

import java.time.LocalDate;

/**
 * ROLE: Manages the scheduling of consultations.
 * CONCEPTS: State Management (Status updates).
 */

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status; // Scheduled, Completed, Cancelled, Rescheduled
    private String reason;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId,
                       LocalDate appointmentDate, String appointmentTime, String reason) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = "Scheduled"; // Default status
        this.reason = reason;
    }

    // Task Specific Methods
    public void reschedule(LocalDate newDate, String newTime) {
        this.appointmentDate = newDate;
        this.appointmentTime = newTime;
        this.status = "Rescheduled";
        System.out.println("Appointment " + appointmentId + " rescheduled.");
    }

    public void cancel() {
        this.status = "Cancelled";
        System.out.println(" Appointment " + appointmentId + " cancelled.");
    }

    public void complete() {
        this.status = "Completed";
        System.out.println(" Appointment " + appointmentId + " marked as completed.");
    }

    public void displayInfo() {
        System.out.println("--- Appointment Details ---");
        System.out.println("ID: " + appointmentId + " | Status: " + status);
        System.out.println("Date/Time: " + appointmentDate + " at " + appointmentTime);
        System.out.println("Patient: " + patientId + " | Doctor: " + doctorId);
        System.out.println("Reason: " + reason);
    }

    // Getters and Setters
    public String getAppointmentId() { return appointmentId; }
    public String getStatus() { return status; }
}