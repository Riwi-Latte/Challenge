// ParkingService.java
package services;

import java.util.*;
import javax.swing.JOptionPane;
import models.Vehicle;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;



public class ParkingService {

    List<Vehicle> parkedVehicles = new ArrayList<>();
    List<Vehicle> vehiclesRecord = new ArrayList<>();
    public Vehicle registerEntry() {
        String[] optionsVehicles = {"MOTORCYCLE", "CAR", "SUV"};
        //int[] optionsLevel = {1,2,3,4};
        String licensePlate = JOptionPane.showInputDialog("Enter the vehicle license plate:");
        String type = JOptionPane.showInputDialog(null,"Enter the vehicle type:", "Select",1,null,optionsVehicles,optionsVehicles[0]).toString();
        //int level = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter the level:", "Select",1,null,optionsLevel,optionsLevel[0]).toString());
        int level = Integer.parseInt(JOptionPane.showInputDialog("Enter the level (1-4):"));
        String entryTime = JOptionPane.showInputDialog("Enter the entry time (dd/MM/yyyy HH:mm):"); // format example: 14:30
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTimeEntry = null;

        try {
            dateTimeEntry = LocalDateTime.parse(entryTime.trim(), formater);
            // ahora puedes guardar fechaHora en una variable: LocalDateTime entrada = fechaHora;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "Invalid format. Use dd/MM/yyyy HH:mm");
            
        }

        Vehicle vehicle = new Vehicle(licensePlate, type, level, dateTimeEntry);
        
        parkedVehicles.add(vehicle);
        vehiclesRecord.add(vehicle);

        // Show vehicle details for confirmation
        
        return vehicle;
    }

    public List<Vehicle> getParkedVehicles() {
        return parkedVehicles;
    }

    public List<Vehicle> getVehiclesRecord() {
        return vehiclesRecord;
    }

    public void registerExit() {

        if(parkedVehicles.size()==0){
            JOptionPane.showMessageDialog(null, "empty list", "Empty list", 0);
            return;
        }

        String[] agreements = {"Convenio Empresa","Residente Nivel","EcoVehículo","none"};
        String licensePlate = JOptionPane.showInputDialog("Enter the vehicle license plate:");
        
        String exitTime = JOptionPane.showInputDialog("Enter the exit time (dd/MM/yyyy HH:mm):");
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dateTime = null;

        try {
            dateTime = LocalDateTime.parse(exitTime.trim(), formater);
            // ahora puedes guardar fechaHora en una variable: LocalDateTime entrada = fechaHora;
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "invalid format. Use dd/MM/yyyy HH:mm");
            
        }
        String[] optionTicket = {"si","no"};
        //String agreement = JOptionPane.showInputDialog("Enter convenio if applicable, otherwise leave blank:");
        String agreement = JOptionPane.showInputDialog(null,"Enter the agreement if applicable, otherwise leave it as none:", "Select",1,null,agreements,agreements[0]).toString();
        String ticketInput = JOptionPane.showInputDialog(null,"you lost your parking ticket?:", "Select",1,null,optionTicket,optionTicket[0]).toString();

        
        Boolean licenFound = false ;
        String getMembership = null;
        String getType = null;
        LocalDateTime getEntryTime = null;
        for(Vehicle vehicle :parkedVehicles){

            if(vehicle.getLicensePlate().equals(licensePlate)){
                licenFound = true;
                getMembership = vehicle.getMembership();
                getEntryTime = vehicle.getEntryTime();
                getType = vehicle.getType();
                vehicle.setExitTime(dateTime);
                break;
            }else{
                licenFound = false;
                
            }
        }
        if (!licenFound){
            
            JOptionPane.showMessageDialog(null, "Vehicle with license plate " + licensePlate + " not found.");
            return;
        }
        Boolean membership = true;
        Boolean lostTicket = false;

        System.out.println(getMembership);

        if (getMembership == null){
            membership = false;
            
        }

        if (ticketInput.equals("si")){
            lostTicket = true;
        }

        Double totalRate = calculateRate(getEntryTime,dateTime,getType,agreement,membership,lostTicket);

        JOptionPane.showMessageDialog(null, "The total parking fee is: $" + totalRate);

        for(Vehicle vehicle :parkedVehicles){

            if(vehicle.getLicensePlate().equals(licensePlate)){
        
                parkedVehicles.remove(vehicle);
                break;
            }
        }

        
         
    }


    public double calculateRate(LocalDateTime entryTime, LocalDateTime exitTime, String type, String convenio, Boolean membership,Boolean lostTicket){

        double hourlyRate = switch (type.toUpperCase()) {
            case "MOTORCYCLE" -> 2500;
            case "CAR" -> 4000;
            case "SUV" -> 5500;
            default -> 0;
        };

        
        long minutes = ChronoUnit.MINUTES.between(entryTime, exitTime);
        long hours = minutes / 60;
        long leftoverMinutes = minutes % 60;


        if (leftoverMinutes >= 15) {
            hours++;
        }

        double total = hours * hourlyRate;

        
        // Recargo nocturno
        int horaEntrada = entryTime.getHour();
        int horaSalida = exitTime.getHour();
        if (horaEntrada >= 21 || horaEntrada < 6 || horaSalida >= 21 || horaSalida < 6) {
            total *= 1.15;
        }

        // Recargo fin de semana
        DayOfWeek dia = entryTime.getDayOfWeek();
        if (dia == DayOfWeek.SATURDAY || dia == DayOfWeek.SUNDAY) {
            total *= 1.10;
        }

        if(membership){
            total = 0;
        }
        
        if (lostTicket) {
            double multa = 20000;
            double dosHorasMinimo = 2 * hourlyRate;
            double operacion = multa + dosHorasMinimo;
            total += operacion; 
        }

        
        double descuento = 0;
        if (convenio.equals("Convenio Empresa")) {
            descuento = 0.12;
        } else if (convenio.equals("Residente Nivel")) {
            descuento = 0.10;
        } else if (convenio.equals("EcoVehículo")) {
            descuento = 0.08;
        }else if (convenio.equals("none")){
            descuento = 0;
        }
        

        if (descuento > 0) {
            total -= total * descuento;
        }

        return total;
    }
}
