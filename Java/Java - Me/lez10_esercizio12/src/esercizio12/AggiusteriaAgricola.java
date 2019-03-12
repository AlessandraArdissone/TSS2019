/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio12;

/**
 *
 * @author tss Alessandra
 */
public class AggiusteriaAgricola {

    final int nAppLavoraz = 10;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Motozappa m = new Motozappa(1, "bosch", 2);
        Tosaerba t = new Tosaerba(3, "viking", 4);
        Decespugliatore d = new Decespugliatore(2, "honda", true);

        System.out.println(m);
        System.out.println(t);
        System.out.println(d);
    }
}
