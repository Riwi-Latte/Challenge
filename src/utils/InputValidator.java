package utils;

import javax.swing.JOptionPane;

public class InputValidator {

    public static String validateLicensePlate() {
        String licensePlate;
        for (int i = 0; i < 3; i++) {
            licensePlate = JOptionPane.showInputDialog("Enter the vehicle license plate:");
            if (isValidLicensePlate(licensePlate)) {
                return licensePlate;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid license plate. Please try again.");
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum number of attempts reached. Operation canceled.");
        return null;
    }

    public static String validateVehicleType() {
        String[] vehicleTypes = {"MOTORCYCLE", "CAR", "SUV"};
        String vehicleType;
        for (int i = 0; i < 3; i++) {
            vehicleType = (String) JOptionPane.showInputDialog(null, "Select the vehicle type:",
                    "Vehicle Type", JOptionPane.QUESTION_MESSAGE, null, vehicleTypes, vehicleTypes[0]);
            if (vehicleType != null) {
                return vehicleType;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid selection. Please try again.");
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum number of attempts reached. Operation canceled.");
        return null;
    }

    public static int validateParkingLevel() {
        int level;
        for (int i = 0; i < 3; i++) {
            String input = JOptionPane.showInputDialog("Enter the parking level (1-4):");
            try {
                level = Integer.parseInt(input);
                if (level >= 1 && level <= 4) {
                    return level;
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid level. Must be between 1 and 4.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please try again.");
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum number of attempts reached. Operation canceled.");
        return -1; // Indicates that the operation was canceled
    }

    public static String validateTime(String prompt) {
        String time;
        for (int i = 0; i < 3; i++) {
            time = JOptionPane.showInputDialog(prompt);
            if (isValidTimeFormat(time)) {
                return time;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid time format. Please try again (HH:mm).");
            }
        }
        JOptionPane.showMessageDialog(null, "Maximum number of attempts reached. Operation canceled.");
        return null;
    }

    private static boolean isValidLicensePlate(String licensePlate) {
        // Implement license plate validation logic
        return licensePlate != null && !licensePlate.trim().isEmpty();
    }

    private static boolean isValidTimeFormat(String time) {
        // Implement time format validation logic
        return time != null && time.matches("\\d{2}:\\d{2}");
    }
}