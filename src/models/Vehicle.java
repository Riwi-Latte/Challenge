package models;

public class Vehicle {
    private String licensePlate;
    private String type; // MOTORCYCLE, CAR, SUV
    private int level;
    private String entryTime;
    private String exitTime;
    private String membership;
    private String convenio;

    public Vehicle(String licensePlate, String type, int level, String entryTime, String exitTime, String membership, String convenio) {
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

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}