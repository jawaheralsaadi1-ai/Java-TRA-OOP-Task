package services;

import entities.Doctor;
import entities.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DoctorService {

    // In-memory database for Doctors
    private static final List<Doctor> doctors = new ArrayList<>();

    //-------------- SECTION 1: ADD METHODS (OVERLOADED) ------------
    public void addDoctor(String name, String specialization, String phone) {
        addDoctor(name, specialization, phone);
    }
    // 1. Quick add with minimal info
    public void addDoctor(String name, String specialization, String phone, double consultationFee) {
        Doctor doctor = new Doctor();
        // 2. Add with consultation fee
        doctor.setFirstName(name); // Assuming 'name' maps to firstName or a combined field
        doctor.setSpecialization(specialization);
        doctor.setPhoneNumber(phone);
        doctor.setConsultationFee(consultationFee);

    addDoctor(doctor);
}
    // 3. Standard add using full object
    private void addDoctor(Doctor doctor) {
        if (doctor != null) {
            doctors.add(doctor);
        }
    }
    //-------------- SECTION 2: PATIENT ASSIGNMENT (OVERLOADED) ------------
    // 1. Assign using IDs (Simulating retrieval)
    public void assignPatient(String doctorId, String patientId) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null) {
            System.out.println("Assigning Patient ID: " + patientId + " to Doctor ID: " + doctorId);
        } else {
            System.out.println("Doctor not found.");
        }
    }
    // 2. Assign using full objects
    public void assignPatient(Doctor doctor, Patient patient) {
        if (doctor != null && patient != null) {
            if (doctor.getAssignedPatients() == null) {
                doctor.setAssignedPatients(new ArrayList<>());
            }
            doctor.getAssignedPatients().add(String.valueOf(patient));
            System.out.println("Patient " + patient.getFirstName() + " assigned to Dr. " + doctor.getFirstName());
        }
    }
    //3. Bulk assignment using list of IDs
    public void assignPatient(String doctorId, List<String> patientIds) {
        Doctor doctor = getDoctorById(doctorId);
        if (doctor != null && patientIds != null) {
            for (String pId : patientIds) {
                assignPatient(doctorId, pId);
            }
            System.out.println("Bulk assignment completed for Doctor: " + doctorId);
        }
    }


    public Doctor getDoctorById(String doctorId) {
        return doctors.stream()
                .filter(d -> d.getDoctorId().equals(doctorId))
                .findFirst()
                .orElse(null);
    }

    //-------------- SECTION 3: DISPLAY METHODS (OVERLOADED) ------------


//1. Display All Doctors
    public void displayAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println(" No doctors in the system.");
            return;
        }

        System.out.println("\n--- All Doctors List ---");
        for (Doctor d : doctors) {
            d.displayInfo();
        }
       //TODO doctors.forEach(Doctor::displayInfo);
    }
    // 2. Display filtered by specialization
    public void displayDoctors(String specialization) {
        System.out.println("\n--- Doctors Specialized in: " + specialization + " ---");
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getSpecialization() != null && d.getSpecialization().equalsIgnoreCase(specialization)) {
                d.displayInfo();
                found = true;
            }
        }
        if (!found) System.out.println("No doctors found with this specialization.");
    }

    // 3. Display by department
    public void displayDoctors(String departmentId, boolean showAvailableOnly) {
        System.out.println("\n--- Doctors in Department: " + departmentId + " ---");
        boolean found = false;
        for (Doctor d : doctors) {
            if (d.getDepartmentId() != null && d.getDepartmentId().equals(departmentId)) {
                if (showAvailableOnly) {
                    // Logic: show if availableSlots list is not empty
                    if (d.getAvailableSlots() != null && !d.getAvailableSlots().isEmpty()) {
                        d.displayInfo();
                        found = true;
                    }
                } else {
                    d.displayInfo();
                    found = true;
                }
            }
        }
        if (!found) System.out.println("No matching doctors found for this criteria.");
    }
}
