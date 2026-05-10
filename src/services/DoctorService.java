package services;

import entities.Doctor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {

    // In-memory database for Doctors
    private static final List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println(" Dr. " + doctor.getLastName() + " added to staff.");
    }

    public Doctor getDoctorById(String doctorId) {
        return doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);
    }

    //
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctors.stream()
                .filter(d -> d.getSpecialization().equalsIgnoreCase(specialization))
                .collect(Collectors.toList());
    }

    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("📭 No doctors in the system.");
            return;
        }
        doctors.forEach(Doctor::displayInfo);
    }

    public void removeDoctor(String doctorId) {
        doctors.removeIf(d -> d.getDoctorId().equals(doctorId));
        System.out.println("🗑️ Doctor removed.");
    }
}
