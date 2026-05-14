package utils;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    // Change 'getInt' to 'getIntInput' to match your Main class
    public static int getIntInput(String prompt, int min, int max) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = Integer.parseInt(scanner.nextLine());
                if (value >= min && value <= max) return value;
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static LocalDate getDateInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return LocalDate.parse(scanner.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use YYYY-MM-DD.");
            }
        }
    }
}