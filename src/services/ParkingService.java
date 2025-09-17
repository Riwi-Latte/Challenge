// ParkingService.java
package services;

import javax.   swing.JOptionPane;
import models.Vehicle;

public class ParkingService {

    public Vehicle registerEntry() {
        String licensePlate = JOptionPane.showInputDialog("Enter the vehicle license plate:");
        String type = JOptionPane.showInputDialog("Enter the vehicle type (MOTORCYCLE, CAR, SUV):");
        int level = Integer.parseInt(JOptionPane.showInputDialog("Enter the level (1-4):"));
        String entryTime = JOptionPane.showInputDialog("Enter the entry time (HH:mm):"); // format example: 14:30

        Vehicle vehicle = new Vehicle(licensePlate, type, level, entryTime);
        
        // Show vehicle details for confirmation
        JOptionPane.showMessageDialog(null, "Vehicle registered:\n" +
                                            "License Plate: " + vehicle.getLicensePlate() + "\n" +
                                            "Type: " + vehicle.getType() + "\n" +
                                            "Level: " + vehicle.getLevel() + "\n" +
                                            "Entry Time: " + entryTime);
        return vehicle;
    }

    // public void registerExit(ParkingTicket ticket) {
    //     String exitTime = JOptionPane.showInputDialog("Enter the exit time (HH:mm):");
    //     ticket.setExitTime(exitTime);
        
    //     // Logic for calculating fee and displaying receipt can be added here
    // }
}