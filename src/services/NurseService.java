package services;

import entities.Nurse;
import java.util.ArrayList;
import java.util.List;

public class NurseService {
    // In-memory database for Nurses
    private static final List<Nurse> nurses = new ArrayList<>();
    // 1. CREATE: Add a new Nurse
    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
        System.out.println("✅ Nurse " + nurse.getLastName() + " added to staff.");
    }
    // 2. READ: Get Nurse by ID
    public List<Nurse> getNursesByShift(String shift) {
        return nurses.stream()
                .filter(n -> n.getShift().equalsIgnoreCase(shift))
                .toList();
    }
// 3. READ: Display all Nurses
    public void displayAllNurses() {
        nurses.forEach(Nurse::displayInfo);
    }
}