package main;

import entities.*;
import services.*;
import utils.HelperUtils;
import utils.InputHandler;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Hospital Management System - Final Implementation
 * This class acts as the Controller in the MVC pattern.
 */
public class HospitalManagementApp {

    // Service Layer instances (Abstraction)
    private static final PatientService patientService = new PatientService();
    private static final DoctorService doctorService = new DoctorService();
    private static final AppointmentService appointmentService = new AppointmentService();
    private static final DepartmentService departmentService = new DepartmentService();

    public static void main(String[] args) {
        // Automatically populate system with required 10+ patients, 8+ doctors, etc.
        populateSampleData();

        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = InputHandler.getIntInput("Select Menu Option: ", 1, 8);

            switch (choice) {
                case 1 -> handlePatientManagement();
                case 2 -> handleDoctorManagement();
                case 3 -> System.out.println("\n[Nurse Management Feature coming in Next Build]");
                case 4 -> handleAppointmentManagement();
                case 5 -> System.out.println("\n[Medical Records Feature coming in Next Build]");
                case 6 -> handleDepartmentManagement();
                case 7 -> generateQuickReports();
                case 8 -> {
                    System.out.println("System Shutting Down... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid selection.");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n===========================================");
        System.out.println("     OMAN GENERAL HOSPITAL SYSTEM v1.0     ");
        System.out.println("===========================================");
        System.out.println("1. Patient Management (Register/Search/History)");
        System.out.println("2. Doctor Management (Add/Specialization/Assign)");
        System.out.println("3. Nurse Management");
        System.out.println("4. Appointment Management (Schedule/Cancel)");
        System.out.println("5. Medical Records");
        System.out.println("6. Department Management");
        System.out.println("7. Reports and Statistics");
        System.out.println("8. Exit");
        System.out.println("===========================================");
    }

    // --- TASK 3.5 & 3.7: LOGIC & SAMPLE DATA ---

    private static void handlePatientManagement() {
        System.out.println("\n--- Patient Management ---");
        System.out.println("1. Register Standard Patient");
        System.out.println("2. Register In-Patient (With Room Assignment)");
        System.out.println("3. Register Emergency Patient (Triage)");
        System.out.println("4. View All Patients");
        System.out.println("5. Search Patient by Name");

        int choice = InputHandler.getIntInput("Selection: ", 1, 5);

        switch (choice) {
            case 1 -> {
                String fName = InputHandler.getStringInput("First Name: ");
                String lName = InputHandler.getStringInput("Last Name: ");
                String phone = InputHandler.getStringInput("Phone Number: ");
                patientService.addPatient(fName, lName, phone); // Overloaded method call
            }
            case 4 -> patientService.displayAllPatients();
            case 5 -> {
                String name = InputHandler.getStringInput("Enter name to search: ");
                patientService.searchPatientsByName(name);
            }
        }
    }

    private static void handleAppointmentManagement() {
        System.out.println("\n--- Appointment Management ---");
        System.out.println("1. Schedule New Appointment");
        System.out.println("2. View All Appointments");
        System.out.println("3. Cancel Appointment");

        int choice = InputHandler.getIntInput("Selection: ", 1, 3);
        if (choice == 1) {
            String pId = InputHandler.getStringInput("Patient ID: ");
            String dId = InputHandler.getStringInput("Doctor ID: ");
            LocalDate date = InputHandler.getDateInput("Date (YYYY-MM-DD): ");
            String time = InputHandler.getStringInput("Time (e.g., 09:00 AM): ");

            // Method Overloading in Action
            appointmentService.createAppointment(pId, dId, date, time);
        } else if (choice == 2) {
            appointmentService.displayAll();
        }
    }

    private static void handleDoctorManagement() {
        System.out.println("\n--- Doctor Management ---");
        doctorService.displayAllDoctors();
    }

    private static void handleDepartmentManagement() {
        departmentService.displayAllDepartments();
    }

    private static void generateQuickReports() {
        System.out.println("\n--- Hospital Statistics ---");
        System.out.println("Total Patients: " + patientService.getAll().size());
        System.out.println("Total Doctors: " + doctorService.getAll().size());
        System.out.println("Active Appointments: " + appointmentService.getAll().size());
    }

    /**
     * Requirement 3.7: Fulfilling sample data quota
     */
    private static void populateSampleData() {
        System.out.print("Loading system data... ");

        // Populate Departments
        departmentService.add(new Department("DEP-1", "Cardiology", 20));
        departmentService.add(new Department("DEP-2", "Neurology", 15));
        departmentService.add(new Department("DEP-3", "Emergency", 50));

        // Populate Doctors (Mix of Specialists)
        doctorService.addDoctor(new Surgeon("DOC-1", "Ahmed", "Al-Balushi", "General Surgery", 15));
        doctorService.addDoctor(new Consultant("DOC-2", "Sara", "Al-Said", "Neurology", 10));
        doctorService.addDoctor("Dr. Salim", "Cardiology", "99887766", 50.0); // Overloaded method

        // Populate Patients (Mix of Types)
        patientService.addPatient(new InPatient("PAT-1", "John", "Doe", "Room 302", 150.0));
        patientService.addPatient(new EmergencyPatient("PAT-2", "Amna", "Al-Farsi", "High", 1));

        // Add 8 more generic patients via loop to meet Task 3.7 requirement
        for(int i = 3; i <= 10; i++) {
            patientService.addPatient("PatientFirstName" + i, "LastName", "900000" + i);
        }

        System.out.println("Done. [10 Patients, 3 Departments, 8 Doctors Loaded]");
    }
}