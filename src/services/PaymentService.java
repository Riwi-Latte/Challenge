package services;

public class PaymentService {

    private static final double MOTORCYCLE_RATE = 2500;
    private static final double CAR_RATE = 4000;
    private static final double TRUCK_RATE = 5500;
    private static final double NIGHT_SURCHARGE = 0.15;
    private static final double WEEKEND_SURCHARGE = 0.10;
    private static final double TICKET_LOST_FINE = 20000;
    private static final double MINIMUM_HOURS_FINE = 2;

    public double calculateBaseRate(String vehicleType, int hours) {
        switch (vehicleType.toUpperCase()) {
            case "MOTORCYCLE":
                return MOTORCYCLE_RATE * hours;
            case "CAR":
                return CAR_RATE * hours;
            case "SUV":
                return TRUCK_RATE * hours;
            default:
                throw new IllegalArgumentException("Invalid vehicle type");
        }
    }

    public double applyNightSurcharge(double total, String exitTime) {
        // Assuming exitTime is in HH:mm format
        String[] timeParts = exitTime.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        if (hour >= 21 || hour < 6) {
            return total * (1 + NIGHT_SURCHARGE);
        }
        return total;
    }

    public double applyWeekendSurcharge(double total, String dayOfWeek) {
        if (dayOfWeek.equalsIgnoreCase("Saturday") || dayOfWeek.equalsIgnoreCase("Sunday")) {
            return total * (1 + WEEKEND_SURCHARGE);
        }
        return total;
    }

    public double applyDiscounts(double total, boolean hasCompanyAgreement, boolean isResident, boolean isEcoVehicle) {
        double discount = 0;
        if (hasCompanyAgreement) {
            discount = 0.12;
        } else if (isResident) {
            discount = 0.10;
        } else if (isEcoVehicle) {
            discount = 0.08;
        }
        return total * (1 - discount);
    }

    public double calculateLostTicketCharge() {
        return TICKET_LOST_FINE + (MINIMUM_HOURS_FINE * MOTORCYCLE_RATE); // Assuming minimum charge for a motorcycle
    }
}