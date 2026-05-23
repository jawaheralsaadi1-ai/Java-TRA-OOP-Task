package services;

import entities.Appointment;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {

    private static List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment added: " + appointment.getAppointmentId());
    }

    public Appointment getAppointmentById(String appointmentId) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId().equals(appointmentId)) {
                return a;
            }
        }
        return null;
    }

    public void removeAppointment(String appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointments.remove(appointment);
            System.out.println("Appointment removed: " + appointmentId);
        } else {
            System.out.println("Appointment not found: " + appointmentId);
        }
    }

    public void editAppointment(String appointmentId, Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getAppointmentId().equals(appointmentId)) {
                appointments.set(i, updatedAppointment);
                System.out.println("Appointment updated: " + appointmentId);
                return;
            }
        }
        System.out.println("Appointment not found: " + appointmentId);
    }

    public List<Appointment> getAppointmentsByPatient(String patientId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getPatientId().equals(patientId)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Appointment> getAppointmentsByDoctor(String doctorId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getDoctorId().equals(doctorId)) {
                result.add(a);
            }
        }
        return result;
    }

    public List<Appointment> getAppointmentsByDate(LocalDate date) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getAppointmentDate().equals(date)) {
                result.add(a);
            }
        }
        return result;
    }

    public void rescheduleAppointment(String appointmentId, LocalDate newDate, String newTime) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setAppointmentDate(newDate);
            appointment.setAppointmentTime(newTime);
            appointment.setStatus("Rescheduled");
            System.out.println("Appointment rescheduled: " + appointmentId);
        } else {
            System.out.println("Appointment not found: " + appointmentId);
        }
    }

    public void cancelAppointment(String appointmentId) {
        Appointment appointment = getAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setStatus("Cancelled");
            System.out.println("Appointment cancelled: " + appointmentId);
        } else {
            System.out.println("Appointment not found: " + appointmentId);
        }
    }
}