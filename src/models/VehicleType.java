package models;

public enum VehicleType {
    MOTORCYCLE(2500),
    CAR(4000),
    SUV(5500);
    
    private final double hourlyRate;
    
    VehicleType(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    
    public double getHourlyRate() {
        return hourlyRate;
    }
}