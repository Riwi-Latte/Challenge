package models;

import java.time.LocalDateTime;

public class Vehicle {
    private String licensePlate;
    private String type; // MOTORCYCLE, CAR, SUV
    private int level;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String membership;


    public Vehicle(String licensePlate, String type, int level, LocalDateTime entryTime) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.level = level;
        this.entryTime = entryTime;
    }



    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public String getMembership() {
        return membership;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }
}