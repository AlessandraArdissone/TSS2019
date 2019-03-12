/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez09_garage;

/**
 *
 * @author tss
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Garage garage = new Garage(); /* creo un'istanza dell'oggetto di classe Garage */

        garage.posteggia(new Auto("Citroen", 2010, 1400, 4, Auto.Alimentazione.DIESEL));
        garage.posteggia(new Furgone("FIAT", 2009, 3500, 5000));
        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));
        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));
        garage.posteggia(new Moto("Triumph", 2018, 1000, Moto.Tempi.QUATTRO_T));
        garage.posteggia(new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));

        System.out.println(garage);
        
        Veicolo uscito= garage.esci(0);
        System.out.println("E' uscito il veicolo: \n" + uscito);
        
        System.out.println(garage);

        uscito= garage.esci(1);
        System.out.println("E' uscito il veicolo: \n" + uscito);
        
        uscito= garage.esci(4);
        System.out.println("E' uscito il veicolo: \n" + uscito);
        
        System.out.println(garage);
    }
}
