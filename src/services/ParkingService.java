// ParkingService.java
package services;

import java.util.*;
import javax.swing.JOptionPane;
import models.Vehicle;

public class ParkingService {

    List<Vehicle> parkedVehicles = new ArrayList<>();
    List<Vehicle> vehiclesRecord = new ArrayList<>();
    public Vehicle registerEntry() {
        String licensePlate = JOptionPane.showInputDialog("Enter the vehicle license plate:");
        String type = JOptionPane.showInputDialog("Enter the vehicle type (MOTORCYCLE, CAR, SUV):");
        int level = Integer.parseInt(JOptionPane.showInputDialog("Enter the level (1-4):"));
        String entryTime = JOptionPane.showInputDialog("Enter the entry time (HH:mm):"); // format example: 14:30

        Vehicle vehicle = new Vehicle(licensePlate, type, level, entryTime);
        
        parkedVehicles.add(vehicle);
        vehiclesRecord.add(vehicle);

        // Show vehicle details for confirmation
        JOptionPane.showMessageDialog(null, parkedVehicles);
        return vehicle;
    }

    public List<Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }

    public List<Vehicle> getVehiclesRecord() {
        return vehiclesRecord;
    }

     public void registerExit() {

        String licensePlate = JOptionPane.showInputDialog("Enter the vehicle license plate:");
        String exitTime = JOptionPane.showInputDialog("Enter the exit time (HH:mm):");
        String agreement = JOptionPane.showInputDialog("Enter convenio if applicable, otherwise leave blank:");


         
  
         // Logic for calculating fee and displaying receipt can be added here
     }
}
