/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lex07;

/**
 *
 * @author tss
 */
public class Giacca {
    
    private int numeroTasche = 4;
    
    private boolean cappuccio = true;
    
    private boolean zipAperta = true ;

    //costruttore
    public Giacca() {
        System.out.println("costruisco una nuova giacca..");
    }

    public void chiudiZip(){
        zipAperta = false;
    }
    
    public String stato(){
        return String.format("La giacca ha %s tasche, cappuccio->%s, zipAperta->%s", numeroTasche,cappuccio,zipAperta);
    }
    
}
