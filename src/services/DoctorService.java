package services;

import entities.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {

    // In-memory database for Doctors
    public static final List<Doctor> doctors = new ArrayList<>();

    //-------------- SECTION 1: ADD METHODS (OVERLOADED) ------------

    /**
     * FIXES BUILD ERROR:
     * Matches call: addDoctor("Dr. Salim", "Cardiology", "99887766", 50.0)
     */
    public void addDoctor(String name, String specialization, String phone, double fee) {
        // We use the 5-argument constructor in Doctor: (firstName, lastName, phone, spec, fee)
        Doctor doctor = new Doctor(name, "", phone, specialization, fee);
        addDoctor(doctor);
    }

    // Standard add using full object
    public void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
        }
    }

    //-------------- SECTION 2: RETRIEVAL & DISPLAY ------------

    /**
     * Requirement 1.8: Returns the list for statistics and counts.
     * Changed from Collection<Object> to List<Doctor> for type safety.
     */
    public List<Doctor> getAll() {
        return doctors;
    }

    /**
     * Requirement 1.8: Display all doctors with formatted output.
     */
    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors are currently registered in the system.");
            return;
        }

        System.out.println("\n--- Registered Doctors List ---");
        for (Doctor d : doctors) {
            d.displayInfo(); // Polymorphism: Works for Doctor, Surgeon, and Consultant
            System.out.println("------------------------------");
        }
    }

    /**
     * Search utility (helpful for the main menu)
     */
    public Doctor getDoctorById(String doctorId) {
        return doctors.stream()
                .filter(d -> d.getDoctorId() != null && d.getDoctorId().equalsIgnoreCase(doctorId))
                .findFirst()
                .orElse(null);
    }
}