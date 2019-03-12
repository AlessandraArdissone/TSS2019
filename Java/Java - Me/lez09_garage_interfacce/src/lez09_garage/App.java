/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez09_garage;

/**
 *
 * @author tss - Alessandra
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Garage garage = new Garage();

        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));
        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));
        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));
        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));

        System.out.println(garage.toString());
        
        Veicolo uscito= garage.esci(0);
        System.out.println("E' uscito il veicolo: " + uscito);
        
        System.out.println(garage);
    }
}
