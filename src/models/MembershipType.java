package models;

public enum MembershipType {
    BASIC(80000),
    PLUS(120000),
    PREMIUM(180000);
    
    private final double monthlyFee;
    
    MembershipType(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
    
    public double getMonthlyFee() {
        return monthlyFee;
    }
}