/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11;

/**
 *
 * @author tss
 */
public class App {
    
    public static void main(String[] args) {
        Sim sim = new Sim("+393498531750",10);
        sim.chiamata(10, "+391234567898");
        sim.chiamata(5, "+391234567898");
        sim.chiamata(3, "+391234567898");
        sim.chiamata(2, "+391234567835");
        sim.chiamata(6, "+391234567835");
        System.out.println(sim);
        
        System.out.println(String.format("totale minuti di comversazione: %s", 
                sim.totaleMinutiConversazione()));
        
        System.out.println(String.format("totale chiamate al numero %s -> %s", 
                "+391234567898",sim.telefonateAlNumero("+391234567898")));
        
        System.out.println(String.format("totale minuti conversazione con il numero %s -> %s", 
                "+391234567898",sim.totaleMinutiConversazioneAlNumero("+391234567898")));
        
        
                   
    }
    
    
}
