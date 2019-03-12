/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez10_esercizio05;

/**
 *
 * @author tss - Alessandra
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Orario orario = new Orario(23, 10, 0);
        
        System.out.println(orario);
        
        orario.aggiungi(1,20,0);

        System.out.println(orario);
        
        orario.sottrai(2,22,0);

        System.out.println(orario);
    }

}
