// Main.java
// This is the entry point of the Park4U application.

import javax.swing.JOptionPane;
import services.ParkingService;

public class Main {
    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService();
        String menu = "Welcome to Park4U\n"
                    + "1. Register entry\n"
                    + "2. Register exit and payment\n"
                    + "3. Memberships\n"
                    + "4. Reports\n"
                    + "5. Cash register\n"
                    + "6. Exit";
        
        int option;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (option) {
                case 1:
                    // Call method to register vehicle entry
                    parkingService.registerEntry();
                    break;
                case 2:
                    // Call method to register exit
                    // parkingService.registerExit();
                    break;
                case 3:
                    // Call method for memberships
                    break;
                case 4:
                    // Call method for reports
                    break;
                case 5:
                    // Call method for cash management
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Thank you for using Park4U!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        } while (option != 6);
    }
}