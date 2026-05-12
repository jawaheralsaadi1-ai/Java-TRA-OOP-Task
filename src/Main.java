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

}