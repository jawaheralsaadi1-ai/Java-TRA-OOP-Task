import entities.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.UUID;

/**
 * PROJECT: Hospital Management System - Day 1 Final Test Verification
 * OBJECTIVE: Verifying Person, Patient, Doctor, Nurse, and Department connections.
 */
void main() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("=== Hospital System: Day 1 Integration Test ===");

    // 1. SETUP DEPARTMENT
    System.out.println("\n[Action] Creating Emergency Department...");
    Department emergency = new Department("DEP-EMR", "Emergency Room", 10);

    // 2. REGISTER A NURSE
    System.out.println("\n[Action] Onboarding Nurse...");
    System.out.print("Enter Nurse First Name: ");
    String nName = scanner.nextLine();

    Nurse nurse = new Nurse(
            UUID.randomUUID().toString(), nName, "Staff", LocalDate.of(1995, 8, 15),
            "Female", "99112233", nName.toLowerCase() + "@hosp.com", "Muscat",
            "NUR-001", "DEP-EMR", "Night Shift", "Registered Nurse (RN)"
    );
    emergency.assignNurse(nurse);

    // 3. REGISTER A DOCTOR
    System.out.println("\n[Action] Onboarding Doctor...");
    System.out.print("Enter Doctor First Name: ");
    String dName = scanner.nextLine();

    Doctor doctor = new Doctor(
            UUID.randomUUID().toString(), dName, "Al-Saadi", LocalDate.of(1980, 5, 10),
            "Male", "99445566", dName.toLowerCase() + "@hosp.com", "Sohar",
            "DOC-777", "General Medicine", "MD", 15, "DEP-EMR", 50.0
    );
    emergency.assignDoctor(doctor);

    // 4. REGISTER A PATIENT
    System.out.println("\n[Action] Registering New Patient...");
    System.out.print("Enter Patient Last Name: ");
    String pLastName = scanner.nextLine();

    Patient patient = new Patient(
            UUID.randomUUID().toString(), "Jawaher", "Al-Saadi", LocalDate.of(2000, 2, 12),
            "Female", "9222222", "jawa@mail.com", "Muscat",
            "PAT-999", "A+", "Brother: 90000000", "INS-VIEW-2026"
    );


}