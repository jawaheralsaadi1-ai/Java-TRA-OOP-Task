package utils;

import java.time.LocalDate;
import java.util.UUID;

public class HelperUtils {

    // 1. Validation for Strings
    public static boolean isValid(String str) {
        return str != null && !str.trim().isEmpty();
    }

    public static boolean isValid(String str, int minLength) {
        return isValid(str) && str.length() >= minLength;
    }

    // 2. ID Generation Logic
    public static String generateId(String prefix) {
        return prefix + "-" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
    }

    // 3. Numeric & Date Checks
    public static boolean isPositive(double val) { return val > 0; }

    public static boolean isFutureDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }
}