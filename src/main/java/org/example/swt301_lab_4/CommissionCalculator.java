package org.example.swt301_lab_4;

public class CommissionCalculator {
    public static final String EXCEPTION_MESSAGE = "itemPrice must not empty and must be greater than zero";
    public static final String BONUS = "BONUS";
    public static final String STANDARD = "STANDARD";
    public static final String GENERAL = "GENERAL";

    public static double calculateCommission(boolean isSalaried, boolean isRegularCustomer, String itemType, double itemPrice) {
        if (itemPrice <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        if (itemType.equals(STANDARD) || isRegularCustomer) {
            return 0D;
        }
        if (itemType.equals(BONUS)) {
            if (isSalaried) {
                return (itemPrice > 1000D) ? 25D : itemPrice * 0.05D;
            } else {
                return (itemPrice > 1000D) ? 75D : itemPrice * 0.10D;
            }
        }
        return (itemPrice > 10000D) ? itemPrice * 0.05D : itemPrice * 0.10D;
    }
}
