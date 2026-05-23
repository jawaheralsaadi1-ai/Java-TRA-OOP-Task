package services;

import entities.Nurse;
import java.util.ArrayList;
import java.util.List;

public class NurseService {

    private static List<Nurse> nurses = new ArrayList<>();

    //
    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
        System.out.println("Nurse added: " + nurse.getFirstName());
    }

    //
    public Nurse getNurseById(String nurseId) {
        for (Nurse n : nurses) {
            if (n.getNurseId().equals(nurseId)) {
                return n;
            }
        }
        return null;
    }

    //
    public void removeNurse(String nurseId) {
        Nurse nurse = getNurseById(nurseId);
        if (nurse != null) {
            nurses.remove(nurse);
            System.out.println("Nurse removed: " + nurseId);
        } else {
            System.out.println("Nurse not found: " + nurseId);
        }
    }

    public void editNurse(String nurseId, Nurse updatedNurse) {
        for (int i = 0; i < nurses.size(); i++) {
            if (nurses.get(i).getNurseId().equals(nurseId)) {
                nurses.set(i, updatedNurse);
                System.out.println("Nurse updated: " + nurseId);
                return;
            }
        }
        System.out.println("Nurse not found: " + nurseId);
    }

    public void displayAllNurses() {
        if (nurses.isEmpty()) {
            System.out.println("No nurses found.");
            return;
        }
        System.out.println("===== All Nurses =====");
        for (Nurse n : nurses) {
            n.displayInfo();
            System.out.println("------------------------");
        }
    }

    public List<Nurse> getNursesByDepartment(String departmentId) {
        List<Nurse> result = new ArrayList<>();
        for (Nurse n : nurses) {
            if (n.getDepartmentId().equals(departmentId)) {
                result.add(n);
            }
        }
        return result;
    }

    public List<Nurse> getNursesByShift(String shift) {
        List<Nurse> result = new ArrayList<>();
        for (Nurse n : nurses) {
            if (n.getShift().equalsIgnoreCase(shift)) {
                result.add(n);
            }
        }
        return result;
    }
}