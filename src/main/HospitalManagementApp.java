package main;

import entities.*;
import services.*;
import interfaces.*;
import utils.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class HospitalManagementApp {

    static PatientService patientService = new PatientService();
    static DoctorService doctorService = new DoctorService();
    static NurseService nurseService = new NurseService();
    static AppointmentService appointmentService = new AppointmentService();
    static DepartmentService departmentService = new DepartmentService();
    static MedicalRecordService medicalRecordService = new MedicalRecordService();

    // ===== Helper =====
    static int menu(String title, String... options) {
        System.out.println("\n===== " + title + " =====");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("0. Back");
        return InputHandler.getIntInput("Choose: ", 0, options.length);
    }

    // ===== Main =====
    public static void main(String[] args) {
        loadSampleData();
        int choice;
        do {
            choice = menu("Hospital Management System",
                    "Patients", "Doctors", "Nurses",
                    "Appointments", "Departments", "Medical Records");
            switch (choice) {
                case 1 -> patientsMenu();
                case 2 -> doctorsMenu();
                case 3 -> nursesMenu();
                case 4 -> appointmentsMenu();
                case 5 -> departmentsMenu();
                case 6 -> medicalRecordsMenu();
                case 0 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // ===== Sample Data =====
    static void loadSampleData() {
        // Departments
        departmentService.addDepartment(new Department("DEPT001", "Cardiology", 20));
        departmentService.addDepartment(new Department("DEPT002", "Neurology", 15));
        departmentService.addDepartment(new Department("DEPT003", "Orthopedics", 25));

        // Doctors
        doctorService.addDoctor(new Doctor(
                "001", "Khalid", "Omar", LocalDate.of(1975, 5, 10),
                "Male", "0501111111", "khalid@hospital.com", "Riyadh",
                "D001", "Cardiology", "MBBS", 15, "DEPT001", 300.0));
        doctorService.addDoctor(new Doctor(
                "002", "Nora", "Ali", LocalDate.of(1980, 8, 20),
                "Female", "0502222222", "nora@hospital.com", "Jeddah",
                "D002", "Neurology", "MD", 10, "DEPT002", 250.0));
        doctorService.addDoctor(new Doctor(
                "003", "Faisal", "Hassan", LocalDate.of(1978, 3, 15),
                "Male", "0503333333", "faisal@hospital.com", "Dammam",
                "D003", "Orthopedics", "MBBS", 12, "DEPT003", 200.0));

        // Patients
        patientService.addPatient(new Patient(
                "001", "Sara", "Ahmed", LocalDate.of(1995, 3, 10),
                "Female", "0501234567", "sara@email.com", "Riyadh",
                "P001", "A+", new ArrayList<>(), "0507654321",
                LocalDate.of(2024, 1, 1), "INS001",
                new ArrayList<>(), new ArrayList<>()));
        patientService.addPatient(new Patient(
                "002", "Omar", "Salem", LocalDate.of(1988, 7, 25),
                "Male", "0509876543", "omar@email.com", "Jeddah",
                "P002", "B+", new ArrayList<>(), "0508765432",
                LocalDate.of(2024, 2, 1), "INS002",
                new ArrayList<>(), new ArrayList<>()));
        patientService.addPatient(new Patient(
                "003", "Lina", "Khalid", LocalDate.of(2000, 11, 5),
                "Female", "0503456789", "lina@email.com", "Dammam",
                "P003", "O+", new ArrayList<>(), "0504567890",
                LocalDate.of(2024, 3, 1), "INS003",
                new ArrayList<>(), new ArrayList<>()));

        // Nurses
        nurseService.addNurse(new Nurse(
                "001", "Hana", "Saeed", LocalDate.of(1992, 4, 18),
                "Female", "0505555555", "hana@hospital.com", "Riyadh",
                "N001", "DEPT001", "Morning", "BSN"));
        nurseService.addNurse(new Nurse(
                "002", "Reem", "Nasser", LocalDate.of(1990, 9, 22),
                "Female", "0506666666", "reem@hospital.com", "Jeddah",
                "N002", "DEPT002", "Evening", "BSN"));

        // Appointments
        appointmentService.addAppointment(new Appointment(
                "A001", "P001", "D001",
                LocalDate.of(2024, 6, 15), "09:00 AM", "Chest Pain"));
        appointmentService.addAppointment(new Appointment(
                "A002", "P002", "D002",
                LocalDate.of(2024, 6, 16), "10:00 AM", "Headache"));
        appointmentService.addAppointment(new Appointment(
                "A003", "P003", "D003",
                LocalDate.of(2024, 6, 17), "11:00 AM", "Knee Pain"));

        // Medical Records
        medicalRecordService.addRecord(new MedicalRecord(
                "R001", "P001", "D001", LocalDate.of(2024, 6, 15),
                "Hypertension", "Amlodipine 5mg", "Normal ECG", "Follow up in 2 weeks"));
        medicalRecordService.addRecord(new MedicalRecord(
                "R002", "P002", "D002", LocalDate.of(2024, 6, 16),
                "Migraine", "Sumatriptan", "Normal MRI", "Avoid stress"));

        System.out.println("\nSample data loaded successfully.\n");
    }

    // ===== Patients =====
    static void patientsMenu() {
        int choice;
        do {
            choice = menu("Patients",
                    "Add Patient", "Display All", "Search by Name",
                    "Remove Patient", "View Medical History");
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> patientService.displayAllPatients();
                case 3 -> patientService
                        .searchPatientsByName(InputHandler.getStringInput("Name: "))
                        .forEach(p -> p.displaySummary());
                case 4 -> patientService.removePatient(
                        InputHandler.getStringInput("Patient ID: "));
                case 5 -> medicalRecordService.displayPatientHistory(
                        InputHandler.getStringInput("Patient ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addPatient() {
        patientService.addPatient(new Patient(
                HelperUtils.generateId("ID"),
                InputHandler.getStringInput("First Name: "),
                InputHandler.getStringInput("Last Name: "),
                InputHandler.getDateInput("DOB"),
                InputHandler.getStringInput("Gender: "),
                InputHandler.getStringInput("Phone: "),
                InputHandler.getStringInput("Email: "),
                InputHandler.getStringInput("Address: "),
                HelperUtils.generateId("PAT"),
                InputHandler.getStringInput("Blood Group: "),
                new ArrayList<>(),
                InputHandler.getStringInput("Emergency Contact: "),
                LocalDate.now(),
                InputHandler.getStringInput("Insurance ID: "),
                new ArrayList<>(), new ArrayList<>()
        ));
    }

    // ===== Doctors =====
    static void doctorsMenu() {
        int choice;
        do {
            choice = menu("Doctors",
                    "Add Doctor", "Display All", "Search by Specialization",
                    "Available Doctors", "Remove Doctor");
            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> doctorService.displayAllDoctors();
                case 3 -> doctorService
                        .getDoctorsBySpecialization(InputHandler.getStringInput("Specialization: "))
                        .forEach(d -> d.displaySummary());
                case 4 -> doctorService.getAvailableDoctors()
                        .forEach(d -> d.displaySummary());
                case 5 -> doctorService.removeDoctor(
                        InputHandler.getStringInput("Doctor ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addDoctor() {
        doctorService.addDoctor(new Doctor(
                HelperUtils.generateId("ID"),
                InputHandler.getStringInput("First Name: "),
                InputHandler.getStringInput("Last Name: "),
                InputHandler.getDateInput("DOB"),
                InputHandler.getStringInput("Gender: "),
                InputHandler.getStringInput("Phone: "),
                InputHandler.getStringInput("Email: "),
                InputHandler.getStringInput("Address: "),
                HelperUtils.generateId("DOC"),
                InputHandler.getStringInput("Specialization: "),
                InputHandler.getStringInput("Qualification: "),
                InputHandler.getIntInput("Experience Years: "),
                InputHandler.getStringInput("Department ID: "),
                InputHandler.getDoubleInput("Consultation Fee: ")
        ));
    }

    // ===== Nurses =====
    static void nursesMenu() {
        int choice;
        do {
            choice = menu("Nurses",
                    "Add Nurse", "Display All", "Search by Department",
                    "Search by Shift", "Remove Nurse");
            switch (choice) {
                case 1 -> addNurse();
                case 2 -> nurseService.displayAllNurses();
                case 3 -> nurseService
                        .getNursesByDepartment(InputHandler.getStringInput("Department ID: "))
                        .forEach(n -> n.displaySummary());
                case 4 -> nurseService
                        .getNursesByShift(InputHandler.getStringInput("Shift (Morning/Evening/Night): "))
                        .forEach(n -> n.displaySummary());
                case 5 -> nurseService.removeNurse(
                        InputHandler.getStringInput("Nurse ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addNurse() {
        nurseService.addNurse(new Nurse(
                HelperUtils.generateId("ID"),
                InputHandler.getStringInput("First Name: "),
                InputHandler.getStringInput("Last Name: "),
                InputHandler.getDateInput("DOB"),
                InputHandler.getStringInput("Gender: "),
                InputHandler.getStringInput("Phone: "),
                InputHandler.getStringInput("Email: "),
                InputHandler.getStringInput("Address: "),
                HelperUtils.generateId("NUR"),
                InputHandler.getStringInput("Department ID: "),
                InputHandler.getStringInput("Shift (Morning/Evening/Night): "),
                InputHandler.getStringInput("Qualification: ")
        ));
    }

    // ===== Appointments =====
    static void appointmentsMenu() {
        int choice;
        do {
            choice = menu("Appointments",
                    "Add Appointment", "Search by Patient", "Search by Doctor",
                    "Cancel Appointment", "Reschedule Appointment");
            switch (choice) {
                case 1 -> addAppointment();
                case 2 -> appointmentService
                        .getAppointmentsByPatient(InputHandler.getStringInput("Patient ID: "))
                        .forEach(a -> a.displaySummary());
                case 3 -> appointmentService
                        .getAppointmentsByDoctor(InputHandler.getStringInput("Doctor ID: "))
                        .forEach(a -> a.displaySummary());
                case 4 -> appointmentService.cancelAppointment(
                        InputHandler.getStringInput("Appointment ID: "));
                case 5 -> appointmentService.rescheduleAppointment(
                        InputHandler.getStringInput("Appointment ID: "),
                        InputHandler.getDateInput("New Date"),
                        InputHandler.getStringInput("New Time: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addAppointment() {
        appointmentService.addAppointment(new Appointment(
                HelperUtils.generateId("APT"),
                InputHandler.getStringInput("Patient ID: "),
                InputHandler.getStringInput("Doctor ID: "),
                InputHandler.getDateInput("Date"),
                InputHandler.getStringInput("Time: "),
                InputHandler.getStringInput("Reason: ")
        ));
    }

    // ===== Departments =====
    static void departmentsMenu() {
        int choice;
        do {
            choice = menu("Departments",
                    "Add Department", "Display All",
                    "Assign Doctor", "Remove Department");
            switch (choice) {
                case 1 -> departmentService.addDepartment(new Department(
                        HelperUtils.generateId("DEPT"),
                        InputHandler.getStringInput("Department Name: "),
                        InputHandler.getIntInput("Bed Capacity: ")));
                case 2 -> departmentService.displayAllDepartments();
                case 3 -> departmentService.assignDoctorToDepartment(
                        InputHandler.getStringInput("Doctor ID: "),
                        InputHandler.getStringInput("Department ID: "));
                case 4 -> departmentService.removeDepartment(
                        InputHandler.getStringInput("Department ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // ===== Medical Records =====
    static void medicalRecordsMenu() {
        int choice;
        do {
            choice = menu("Medical Records",
                    "Add Record", "Patient History",
                    "Search by Doctor", "Remove Record");
            switch (choice) {
                case 1 -> addMedicalRecord();
                case 2 -> medicalRecordService.displayPatientHistory(
                        InputHandler.getStringInput("Patient ID: "));
                case 3 -> medicalRecordService
                        .getRecordsByDoctorId(InputHandler.getStringInput("Doctor ID: "))
                        .forEach(r -> r.displaySummary());
                case 4 -> medicalRecordService.removeRecord(
                        InputHandler.getStringInput("Record ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addMedicalRecord() {
        medicalRecordService.addRecord(new MedicalRecord(
                HelperUtils.generateId("REC"),
                InputHandler.getStringInput("Patient ID: "),
                InputHandler.getStringInput("Doctor ID: "),
                InputHandler.getDateInput("Visit Date"),
                InputHandler.getStringInput("Diagnosis: "),
                InputHandler.getStringInput("Prescription: "),
                InputHandler.getStringInput("Test Results: "),
                InputHandler.getStringInput("Notes: ")
        ));
    }
}