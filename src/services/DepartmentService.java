package services;

import entities.Department;
import entities.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService {

    private static List<Department> departments = new ArrayList<>();

    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department added: " + department.getDepartmentName());
    }

    public Department getDepartmentById(String departmentId) {
        for (Department d : departments) {
            if (d.getDepartmentId().equals(departmentId)) {
                return d;
            }
        }
        return null;
    }

    public void removeDepartment(String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department != null) {
            departments.remove(department);
            System.out.println("Department removed: " + departmentId);
        } else {
            System.out.println("Department not found: " + departmentId);
        }
    }

    public void editDepartment(String departmentId, Department updatedDepartment) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentId().equals(departmentId)) {
                departments.set(i, updatedDepartment);
                System.out.println("Department updated: " + departmentId);
                return;
            }
        }
        System.out.println("Department not found: " + departmentId);
    }

    public void displayAllDepartments() {
        if (departments.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }
        System.out.println("===== All Departments =====");
        for (Department d : departments) {
            d.displayInfo();
            System.out.println("------------------------");
        }
    }

    public void assignDoctorToDepartment(String doctorId, String departmentId) {
        Department department = getDepartmentById(departmentId);
        if (department == null) {
            System.out.println("Department not found: " + departmentId);
            return;
        }

        for (Doctor d : department.getDoctors()) {
            if (d.getDoctorId().equals(doctorId)) {
                System.out.println("Doctor already assigned to this department.");
                return;
            }
        }

        DoctorService doctorService = new DoctorService();
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor != null) {
            doctor.setDepartmentId(departmentId);
            department.assignDoctor(doctor);
        } else {
            System.out.println("Doctor not found: " + doctorId);
        }
    }
}