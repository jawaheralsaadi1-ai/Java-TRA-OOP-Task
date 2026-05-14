package entities;

import java.time.LocalDate;

public class OutPatient extends Patient {
    private LocalDate lastVisitDate;

    public OutPatient(String firstName, String lastName, String phone, String patientId) {
        super(firstName, lastName, phone, patientId);
        this.lastVisitDate = LocalDate.now();
    }
}