public class Membership {
    private String licensePlate;
    private String membershipType; // BASIC, PLUS, PREMIUM
    private boolean isActive;

    public Membership(String licensePlate, String membershipType) {
        this.licensePlate = licensePlate;
        this.membershipType = membershipType;
        this.isActive = true; // New memberships are active by default
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void deactivateMembership() {
        this.isActive = false;
    }

    public void activateMembership() {
        this.isActive = true;
    }
}