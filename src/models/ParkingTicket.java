package models;

// Add this import statement
import models.Vehicle;

public class ParkingTicket {
    private Vehicle vehicle;
    private String entryTime;
    private String exitTime;

    public ParkingTicket(Vehicle vehicle, String entryTime) {
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public double calculateFee() {
        // Implement fee calculation logic based on vehicle type and duration
        return 0.0; // Placeholder return value
    }
}