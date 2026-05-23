package main;

import entities.*;
import services.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementApp {

    static Scanner scanner = new Scanner(System.in);
    static PatientService patientService = new PatientService();
    static DoctorService doctorService = new DoctorService();
    static NurseService nurseService = new NurseService();
    static AppointmentService appointmentService = new AppointmentService();
    static DepartmentService departmentService = new DepartmentService();
    static MedicalRecordService medicalRecordService = new MedicalRecordService();

    // ===== Helper Methods =====
    static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    static int menu(String title, String... options) {
        System.out.println("\n===== " + title + " =====");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.println("0. Back");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    // ===== Main =====
    public static void main(String[] args) {
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

    // ===== Patients =====
    static void patientsMenu() {
        int choice;
        do {
            choice = menu("Patients", "Add", "Display All", "Search by Name", "Remove");
            switch (choice) {
                case 1 -> addPatient();
                case 2 -> patientService.displayAllPatients();
                case 3 -> patientService.searchPatientsByName(input("Name: "))
                        .forEach(p -> p.displayInfo());
                case 4 -> patientService.removePatient(input("Patient ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addPatient() {
        patientService.addPatient(new Patient(
                input("ID: "), input("First Name: "), input("Last Name: "),
                LocalDate.parse(input("DOB (YYYY-MM-DD): ")),
                input("Gender: "), input("Phone: "),
                input("Email: "), input("Address: "),
                input("Patient ID: "), input("Blood Group: "),
                new ArrayList<String>(), input("Emergency Contact: "),
                LocalDate.now(), input("Insurance ID: "),
                new ArrayList<String>(), new ArrayList<String>()
        ));
    }

    // ===== Doctors =====
    static void doctorsMenu() {
        int choice;
        do {
            choice = menu("Doctors", "Add", "Display All",
                    "Search by Specialization", "Available Doctors", "Remove");
            switch (choice) {
                case 1 -> addDoctor();
                case 2 -> doctorService.displayAllDoctors();
                case 3 -> doctorService.getDoctorsBySpecialization(input("Specialization: "))
                        .forEach(d -> d.displayInfo());
                case 4 -> doctorService.getAvailableDoctors()
                        .forEach(d -> d.displayInfo());
                case 5 -> doctorService.removeDoctor(input("Doctor ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addDoctor() {
        doctorService.addDoctor(new Doctor(
                input("ID: "), input("First Name: "), input("Last Name: "),
                LocalDate.parse(input("DOB (YYYY-MM-DD): ")),
                input("Gender: "), input("Phone: "),
                input("Email: "), input("Address: "),
                input("Doctor ID: "), input("Specialization: "),
                input("Qualification: "),
                Integer.parseInt(input("Experience Years: ")),
                input("Department ID: "),
                Double.parseDouble(input("Consultation Fee: "))
        ));
    }

    // ===== Nurses =====
    static void nursesMenu() {
        int choice;
        do {
            choice = menu("Nurses", "Add", "Display All",
                    "Search by Department", "Search by Shift", "Remove");
            switch (choice) {
                case 1 -> addNurse();
                case 2 -> nurseService.displayAllNurses();
                case 3 -> nurseService.getNursesByDepartment(input("Department ID: "))
                        .forEach(n -> n.displayInfo());
                case 4 -> nurseService.getNursesByShift(input("Shift (Morning/Evening/Night): "))
                        .forEach(n -> n.displayInfo());
                case 5 -> nurseService.removeNurse(input("Nurse ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addNurse() {
        nurseService.addNurse(new Nurse(
                input("ID: "), input("First Name: "), input("Last Name: "),
                LocalDate.parse(input("DOB (YYYY-MM-DD): ")),
                input("Gender: "), input("Phone: "),
                input("Email: "), input("Address: "),
                input("Nurse ID: "), input("Department ID: "),
                input("Shift (Morning/Evening/Night): "),
                input("Qualification: ")
        ));
    }

    // ===== Appointments =====
    static void appointmentsMenu() {
        int choice;
        do {
            choice = menu("Appointments", "Add", "Search by Patient",
                    "Search by Doctor", "Cancel", "Reschedule");
            switch (choice) {
                case 1 -> addAppointment();
                case 2 -> appointmentService.getAppointmentsByPatient(input("Patient ID: "))
                        .forEach(a -> System.out.println(
                                a.getAppointmentId() + " | " +
                                        a.getAppointmentDate() + " | " +
                                        a.getStatus()));
                case 3 -> appointmentService.getAppointmentsByDoctor(input("Doctor ID: "))
                        .forEach(a -> System.out.println(
                                a.getAppointmentId() + " | " +
                                        a.getAppointmentDate() + " | " +
                                        a.getStatus()));
                case 4 -> appointmentService.cancelAppointment(input("Appointment ID: "));
                case 5 -> appointmentService.rescheduleAppointment(
                        input("Appointment ID: "),
                        LocalDate.parse(input("New Date (YYYY-MM-DD): ")),
                        input("New Time: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addAppointment() {
        appointmentService.addAppointment(new Appointment(
                input("Appointment ID: "), input("Patient ID: "),
                input("Doctor ID: "),
                LocalDate.parse(input("Date (YYYY-MM-DD): ")),
                input("Time: "), input("Reason: ")
        ));
    }

    // ===== Departments =====
    static void departmentsMenu() {
        int choice;
        do {
            choice = menu("Departments", "Add", "Display All",
                    "Assign Doctor", "Remove");
            switch (choice) {
                case 1 -> departmentService.addDepartment(new Department(
                        input("Department ID: "), input("Department Name: "),
                        Integer.parseInt(input("Bed Capacity: "))));
                case 2 -> departmentService.displayAllDepartments();
                case 3 -> departmentService.assignDoctorToDepartment(
                        input("Doctor ID: "), input("Department ID: "));
                case 4 -> departmentService.removeDepartment(input("Department ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    // ===== Medical Records =====
    static void medicalRecordsMenu() {
        int choice;
        do {
            choice = menu("Medical Records", "Add", "Patient History",
                    "Search by Doctor", "Remove");
            switch (choice) {
                case 1 -> addMedicalRecord();
                case 2 -> medicalRecordService.displayPatientHistory(input("Patient ID: "));
                case 3 -> medicalRecordService.getRecordsByDoctorId(input("Doctor ID: "))
                        .forEach(r -> r.displayInfo());
                case 4 -> medicalRecordService.removeRecord(input("Record ID: "));
                case 0 -> System.out.println("Back...");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void addMedicalRecord() {
        medicalRecordService.addRecord(new MedicalRecord(
                input("Record ID: "), input("Patient ID: "),
                input("Doctor ID: "),
                LocalDate.parse(input("Visit Date (YYYY-MM-DD): ")),
                input("Diagnosis: "), input("Prescription: "),
                input("Test Results: "), input("Notes: ")
        ));
    }
}