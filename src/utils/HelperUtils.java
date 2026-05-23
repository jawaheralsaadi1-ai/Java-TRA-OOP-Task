package utils;

import java.time.LocalDate;
import java.util.UUID;

public class HelperUtils {

    // ===== Null Check Methods =====
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static boolean isNull(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static boolean isNotNull(String str) {
        return str != null && !str.isEmpty();
    }

    // ===== String Validation Methods =====
    public static boolean isValidString(String str) {
        return str != null && !str.isEmpty();
    }

    public static boolean isValidString(String str, int minLength) {
        return isValidString(str) && str.length() >= minLength;
    }

    public static boolean isValidString(String str, int minLength, int maxLength) {
        return isValidString(str) && str.length() >= minLength && str.length() <= maxLength;
    }

    public static boolean isValidString(String str, String regex) {
        return isValidString(str) && str.matches(regex);
    }

    // ===== ID Generation Methods =====
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    public static String generateId(String prefix) {
        return prefix + "-" + (int)(Math.random() * 90000 + 10000);
    }

    public static String generateId(String prefix, int length) {
        StringBuilder id = new StringBuilder(prefix + "-");
        for (int i = 0; i < length; i++) {
            id.append((int)(Math.random() * 10));
        }
        return id.toString();
    }

    public static String generateId(String prefix, String suffix) {
        return prefix + "-" + (int)(Math.random() * 90000 + 10000) + "-" + suffix;
    }

    // ===== Date Validation Methods =====
    public static boolean isValidDate(LocalDate date) {
        return date != null;
    }

    public static boolean isValidDate(String dateStr) {
        try {
            LocalDate.parse(dateStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidDate(LocalDate date, LocalDate minDate, LocalDate maxDate) {
        return isValidDate(date) &&
                !date.isBefore(minDate) &&
                !date.isAfter(maxDate);
    }

    public static boolean isFutureDate(LocalDate date) {
        return isValidDate(date) && date.isAfter(LocalDate.now());
    }

    public static boolean isPastDate(LocalDate date) {
        return isValidDate(date) && date.isBefore(LocalDate.now());
    }

    public static boolean isToday(LocalDate date) {
        return isValidDate(date) && date.isEqual(LocalDate.now());
    }

    // ===== Numeric Validation Methods =====
    public static boolean isValidNumber(int num, int min, int max) {
        return num >= min && num <= max;
    }

    public static boolean isValidNumber(double num, double min, double max) {
        return num >= min && num <= max;
    }

    public static boolean isPositive(int num) {
        return num > 0;
    }

    public static boolean isPositive(double num) {
        return num > 0;
    }

    public static boolean isNegative(int num) {
        return num < 0;
    }

    public static boolean isNegative(double num) {
        return num < 0;
    }

    // ===== Input Validation Methods =====
    public static boolean isValidAge(int age) {
        return age > 0 && age <= 120;
    }

    public static boolean isValidAge(LocalDate dateOfBirth) {
        if (!isValidDate(dateOfBirth)) return false;
        int age = LocalDate.now().getYear() - dateOfBirth.getYear();
        return isValidAge(age);
    }
}