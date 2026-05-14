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

    // 1. Basic creation with minimum info
    public void createAppointment(String patientId, String doctorId, LocalDate date) {
        createAppointment(patientId, doctorId, date, "09:00 AM");
    }

    // 2. Creation with specific time
    public void createAppointment(String patientId, String doctorId, LocalDate date, String time) {
        Appointment appt = new Appointment();
        appt.setPatientId(patientId);
        appt.setDoctorId(doctorId);
        appt.setAppointmentDate(date);
        appt.setAppointmentTime(time);
        appt.setStatus("Scheduled");

        createAppointment(appt);
    }

    // 3. Standard creation with full object
    public void createAppointment(Appointment appointment) {
        if (appointment != null) {
            appointments.add(appointment);
        }
    }

    //-------------- SECTION 2: RESCHEDULE (OVERLOADED) ------------

    public void rescheduleAppointment(String appointmentId, LocalDate newDate) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                System.out.println("Appointment date updated for: " + appointmentId);
                return;
            }
        }
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setAppointmentDate(newDate);
                a.setAppointmentTime(newTime);
                System.out.println("Appointment date and time updated.");
                return;
            }
        }
    }

    public void rescheduleAppointment(Appointment appointment, LocalDate newDate, String newTime, String reason) {
        if (appointment != null) {
            appointment.setAppointmentDate(newDate);
            appointment.setAppointmentTime(newTime);
            appointment.setReason(reason);
            appointment.setStatus("Rescheduled");
            System.out.println("Appointment rescheduled with reason.");
        }
    }

    //-------------- SECTION 3: DISPLAY (OVERLOADED) ------------

    public void displayAppointments(LocalDate date) {
        System.out.println("\n--- Appointments for: " + date + " ---");
        boolean found = false;
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(date)) {
                a.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No appointments found on this date.");
    }

    public void displayAppointments(String doctorId, LocalDate startDate, LocalDate endDate) {
        System.out.println("\n--- Appointments for Doctor: " + doctorId + " ---");
        for (Appointment a : appointments) {
            if (a.getDoctorId().equals(doctorId)) {
                LocalDate d = a.getAppointmentDate();
                if (!d.isBefore(startDate) && !d.isAfter(endDate)) {
                    a.displayInfo();
                }
            }
        }
    }

    //-------------- SECTION 4: ADDITIONAL LOGIC ------------

    public void cancelAppointment(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                a.setStatus("Cancelled");
                System.out.println("Appointment " + appointmentId + " has been cancelled.");
                return;
            }
        }
    }
}