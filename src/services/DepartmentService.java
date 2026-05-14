package services;

import entities.Department;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {
    private final List<Department> departments = new ArrayList<>();

    // Fixes "cannot find symbol method add(entities.Department)"
    public void add(Department dept) {
        if (dept != null) {
            departments.add(dept);
        }
    }

    public void displayAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments registered.");
            return;
        }
        departments.forEach(Department::displayInfo);
    }
}