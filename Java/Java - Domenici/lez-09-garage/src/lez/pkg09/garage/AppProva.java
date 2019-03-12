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
public class AppProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Object o = new Auto("Suzuki", 2015, 1200, 4, Auto.Alimentazione.BENZINA);

        Object v = new Moto(Moto.Tempi.DUE_T,"Honda", 2015, 1200);
        
        Prova p = new Prova();
        
        
        stampaRappresentazioneString(o);
        
        stampaRappresentazioneString(v);
        
        stampaRappresentazioneString(p);
        
    }

    
    private static void stampaRappresentazioneString(Object o){
        System.out.println(o.toString());
    }
}
