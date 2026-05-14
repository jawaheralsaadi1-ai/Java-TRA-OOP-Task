package main;

import java.util.Scanner;
import utils.HelperUtils;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        String input = scanner.nextLine();
        return HelperUtils.isValid(input) ? input : getString("Invalid input! " + prompt);
    }

    public static int getInt(String prompt, int min, int max) {
        System.out.print(prompt + " (" + min + "-" + max + "): ");
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice >= min && choice <= max) return choice;
        } catch (Exception e) {}
        System.out.println("Error: Please enter a number between " + min + " and " + max);
        return getInt(prompt, min, max);
    }
}