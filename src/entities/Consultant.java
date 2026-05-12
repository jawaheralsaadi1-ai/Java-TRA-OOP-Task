package entities;

import java.time.LocalDate;
import java.util.List;

public class Consultant extends Doctor {

    // 1. Add specific data , should be 'private'
    private List<String>consultion;
    private boolean onlineConsultiantAvailable;
    private int consultationDuration;

    // 2. Updated Constructor
    public Consultant(String id, String firstName, String lastName, LocalDate dateOfBirth,
                      String gender, String phoneNumber, String email, String address,
                      String doctorId, String specialization, String qualification,
                      int experienceYears, String departmentId, double consultationFee,
                      boolean onlineConsultiantAvailable, List<String> consultion, int consultationDuration)
    {
        // Pass  mandatory identity data to the Doctor class
        super(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, doctorId, specialization, qualification, experienceYears, departmentId, consultationFee);
        this.onlineConsultiantAvailable = onlineConsultiantAvailable;
        this.consultion = consultion;
        this.consultationDuration = consultationDuration;
    }


    }

