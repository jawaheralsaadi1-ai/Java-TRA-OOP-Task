package utils;

import java.time.LocalDate;
import java.util.Scanner;

public class InputHandler {

    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        while (!HelperUtils.isValidString(input)) {
            System.out.print("لا يمكن أن يكون فارغاً. " + prompt);
            input = scanner.nextLine();
        }
        return input;
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("أدخلي رقماً صحيحاً. " + prompt);
            scanner.nextLine();
        }
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    public static int getIntInput(String prompt, int min, int max) {
        int value;
        do {
            value = getIntInput(prompt);
            if (!HelperUtils.isValidNumber(value, min, max)) {
                System.out.println("الرقم يجب أن يكون بين " + min + " و " + max);
            }
        } while (!HelperUtils.isValidNumber(value, min, max));
        return value;
    }

    public static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.print("أدخلي رقماً صحيحاً. " + prompt);
            scanner.nextLine();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    public static LocalDate getDateInput(String prompt) {
        System.out.print(prompt + " (YYYY-MM-DD): ");
        String input = scanner.nextLine();
        while (!HelperUtils.isValidDate(input)) {
            System.out.print("تاريخ غير صحيح. " + prompt + " (YYYY-MM-DD): ");
            input = scanner.nextLine();
        }
        return LocalDate.parse(input);
    }

    public static boolean getConfirmation(String prompt) {
        System.out.print(prompt + " (yes/no): ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y");
    }
}