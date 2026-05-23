package entities;

import interfaces.Displayable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Appointment implements Displayable {
    private String notes;
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String status; // Scheduled, Completed, Cancelled, Rescheduled
    private String reason;

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

    public Appointment(String s, String string, String s1, LocalDate now, String time, String scheduled, String generalCheckup, String string1) {
        
    }


    // Basic Note
    public void addNotes(String notes) {
        this.notes = notes;
    }

    // Note with
    public void addNotes(String notes, String addedBy) {
        this.notes = notes + " | Added by: " + addedBy;
    }

    // Full Audit Note
    public void addNotes(String notes, String addedBy, LocalDateTime timestamp) {
        this.notes = String.format("[%s] %s (Author: %s)", timestamp, notes, addedBy);
    }

    public void setPatientId(String patientId) {
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDoctorId(String doctorId) {
    }
    @Override
    public void displayInfo() {
        System.out.println("Appointment: " + appointmentId +
                " | Patient: " + patientId +
                " | Doctor: " + doctorId +
                " | Date: " + appointmentDate +
                " | Status: " + status);
    }

    @Override
    public void displaySummary() {
        System.out.println("Appointment " + appointmentId +
                " | " + appointmentDate + " | " + status);
    }
}