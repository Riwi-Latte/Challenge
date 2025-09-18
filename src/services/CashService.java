package services;

import javax.swing.JOptionPane;

public class CashService {
    private int ticketsCobrados;
    private double totalMotos;
    private double totalCarros;
    private double totalCamionetas;
    private double totalMultas;
    private double totalDescuentos;
    private double totalRecargos;

    public CashService() {
        this.ticketsCobrados = 0;
        this.totalMotos = 0;
        this.totalCarros = 0;
        this.totalCamionetas = 0;
        this.totalMultas = 0;
        this.totalDescuentos = 0;
        this.totalRecargos = 0;
    }

   
    public void registrarCobro(String tipoVehiculo, double valorCobrado, double descuento, double recargo) {
        ticketsCobrados++;
        switch (tipoVehiculo.toUpperCase()) {
            case "MOTO": totalMotos += valorCobrado; break;
            case "CARRO": totalCarros += valorCobrado; break;
            case "CAMIONETA": totalCamionetas += valorCobrado; break;
        }
        totalDescuentos += descuento;
        totalRecargos += recargo;
    }

   
    public void registrarMulta(double valorMulta) {
        ticketsCobrados++;
        totalMultas += valorMulta;
    }

    
    public void mostrarReporteTurno() {
        double totalGeneral = totalMotos + totalCarros + totalCamionetas + totalMultas;
        String reporte = " Reporte de Caja - Turno Actual\n\n" +
                "Tickets cobrados: " + ticketsCobrados + "\n" +
                "Subtotal Motos: $" + totalMotos + "\n" +
                "Subtotal Carros: $" + totalCarros + "\n" +
                "Subtotal Camionetas: $" + totalCamionetas + "\n" +
                "Multas: $" + totalMultas + "\n" +
                "Descuentos aplicados: $" + totalDescuentos + "\n" +
                "Recargos aplicados: $" + totalRecargos + "\n" +
                "-----------------------------------\n" +
                "TOTAL GENERAL: $" + totalGeneral;

        JOptionPane.showMessageDialog(null, reporte, "Reporte de Caja", JOptionPane.INFORMATION_MESSAGE);
    }

    public void cerrarTurno() {
        mostrarReporteTurno();
        ticketsCobrados = 0;
        totalMotos = 0;
        totalCarros = 0;
        totalCamionetas = 0;
        totalMultas = 0;
        totalDescuentos = 0;
        totalRecargos = 0;
        JOptionPane.showMessageDialog(null, "Turno cerrado. Reporte de caja reiniciado...");
    }
}


// public class placa {
//     private String placa;
//     private int tipoVehiculo;
//     private String membresia;
//     private double horaEntrada;
   

//     public placa() {
//         this.placa = "";
//         this.tipoVehiculo = 0;
//         this.membresia = "";
//         this.horaEntrada = 0;
//     }

// }