/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez.pkg09.garage;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
        
        Garage garage = new Garage();
        
        garage.posteggia( new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA));
        
        garage.posteggia(new Moto(Moto.Tempi.DUE_T,"Honda", 2015, 1200));
        
        garage.posteggia(new Moto(Moto.Tempi.QUATTRO_T,"Triumph", 2017, 1200));
        
        System.out.println(garage.toString());
        
        Veicolo uscito = garage.esci(0);
        
        System.out.println("E' uscito il veicolo: " + uscito);
        
        System.out.println(garage.toString());
    }
}
