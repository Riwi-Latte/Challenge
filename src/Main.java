// Main.java
// This is the entry point of the Park4U application.

import javax.swing.JOptionPane;

import services.CashService;
import services.ParkingService;

public class Main {
    public static void main(String[] args) {
        ParkingService parkingService = new ParkingService();
        CashService caja = new CashService();

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
                    parkingService.registerEntry();
                    break;
                case 2:
                    // Call method to register exit
                    // parkingService.registerExit();
                case 3:
                    // Memberships
                    break;
                case 4:
                    // Reports
                    break;
                case 5:
                    String subMenu = "Cash Register:\n"
                            + "1. Show current report\n"
                            + "2. Close shift\n";

                    int cashOption = 0;
                    boolean validInput = false;

                    do {
                        String input = JOptionPane.showInputDialog(subMenu);
                        if (input == null) {
                            break;
                        }

                        try {
                            cashOption = Integer.parseInt(input);
                            if (cashOption == 1) {
                                caja.mostrarReporteTurno();
                                validInput = true;
                            } else if (cashOption == 2) {
                                caja.cerrarTurno();
                                validInput = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid option. Please enter 1 or 2.");
                            }
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                        }
                    } while (!validInput);
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
