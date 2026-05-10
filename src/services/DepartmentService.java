package services;

import entities.Department;
import entities.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 * SERVICE: DepartmentService
 * Purpose: Organizes hospital departments and assigns staff.
 */

public class DepartmentService {
    private static final List<Department> departments = new ArrayList<>();

    // CREATE
    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    // READ: Get specific department
    public Department getDepartmentById(String id) {
        return departments.stream()
                .filter(d -> d.getDepartmentId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // READ: Display all
    public void displayAllDepartments() {
        System.out.println("\n--- Hospital Departments ---");
        departments.forEach(d -> System.out.println(d.getDepartmentName() + " [" + d.getDepartmentId() + "]"));
    }

    // UPDATE: Assign doctor to department
    public void assignDoctorToDepartment(DoctorService docSrv, String doctorId, String deptId) {
        Doctor doc = docSrv.getDoctorById(doctorId);
        Department dept = getDepartmentById(deptId);

        if (doc != null && dept != null) {
            dept.assignDoctor(doc);
            System.out.println("SUCCESS: Dr. " + doc.getLastName() + " moved to " + dept.getDepartmentName());
        } else {
            System.out.println("ERROR: Missing Doctor or Department ID.");
        }
    }
}