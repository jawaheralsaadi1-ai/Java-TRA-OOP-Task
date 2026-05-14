package entities;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private double consultationFee;
    private List<String> availableSlots = new ArrayList<>();

    public Doctor(String firstName, String lastName, String phoneNumber) {
        super(firstName, lastName, phoneNumber);
    }

    // Fee Overloading
    public void updateFee(double fee) {
        this.consultationFee = fee;
    }

    public void updateFee(double fee, String reason) {
        this.updateFee(fee);
        System.out.println("Fee adjusted. Reason: " + reason);
    }

    // Availability Overloading
    public void addAvailability(String slot) {
        this.availableSlots.add(slot);
    }

    public void addAvailability(List<String> slots) {
        if (slots != null) {
            this.availableSlots.addAll(slots);
        }
    }
}