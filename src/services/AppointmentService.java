package services;

import entities.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * SERVICE: AppointmentService
 * Purpose: Handles scheduling, cancellations, and status updates.
 */
public class AppointmentService {
    private static final List<Appointment> appointments = new ArrayList<>();

    // CREATE
    public void createAppointment(Appointment appt) {
        appointments.add(appt);
    }

    // READ: Filter by patient
    public List<Appointment> getAppointmentsByPatient(String patientId) {
        return appointments.stream()
                .filter(a -> a.getPatientId().equals(patientId))
                .toList();
    }

    // READ: Filter by doctor
    public List<Appointment> getAppointmentsByDoctor(String doctorId) {
        return appointments.stream()
                .filter(a -> a.getDoctorId().equals(doctorId))
                .toList();
    }

    // READ: Filter by date
    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        return appointments.stream()
                .filter(a -> a.getAppointmentDate().equals(date))
                .toList();
    }

    // UPDATE: Reschedule
    public void rescheduleAppointment(String id, LocalDate newDate, String newTime) {
        appointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst()
                .ifPresent(a -> a.reschedule(newDate, newTime));
    }

    // UPDATE: Cancel
    public void cancelAppointment(String id) {
        appointments.stream()
                .filter(a -> a.getAppointmentId().equals(id))
                .findFirst()
                .ifPresent(Appointment::cancel);
    }
}