package services;

import entities.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    private static final List<Doctor> doctors = new ArrayList<>();

    // Add doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: " + doctor.getFirstName());
    }

    //
    public Doctor getDoctorById(String doctorId) {
        for (Doctor d : doctors) {
            if (d.getDoctorId().equals(doctorId)) {
                return d;
            }
        }
        return null;
    }

    //
    public void removeDoctor(String doctorId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            doctors.remove(doctor);
            System.out.println("Doctor removed: " + doctorId);
        } else {
            System.out.println("Doctor not found: " + doctorId);
        }
    }

    //
    public void editDoctor(String doctorId, Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getDoctorId().equals(doctorId)) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor updated: " + doctorId);
                return;
            }
        }
        System.out.println("Doctor not found: " + doctorId);
    }

    //
    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("===== All Doctors =====");
        for (Doctor d : doctors) {
            d.displayInfo();
            System.out.println("------------------------");
        }
    }

    //
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getSpecialization().equalsIgnoreCase(specialization)) {
                result.add(d);
            }
        }
        return result;
    }

    public List<Doctor> getAvailableDoctors() {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.setAvailableSlots()) {
                result.add(d);
            }
        }
        return result;
    }
}