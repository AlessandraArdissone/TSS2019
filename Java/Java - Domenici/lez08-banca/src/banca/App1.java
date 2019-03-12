/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banca;

/**
 *
 * @author tss
 */
public class App1 {
    
    public static void main(String[] args) {
        
       
        
        ContoCorrente cc1 = new ContoCorrente(1, "Rossi");
        
        ContoCorrente cc2 = new ContoCorrente(2, "Verdi");
        
        cc1.deposito(50);
        
        cc2.deposito(100);
        
        App.stampaConto(cc1);
        
        App.stampaConto(cc2);
        
        //ContoCorrente.modificaInteresse(0.1f);
        
        cc1.modificaInteresse(0.1f);
        
        App.stampaConto(cc1);
        
        App.stampaConto(cc2);
        
        
    }
    
    
}
