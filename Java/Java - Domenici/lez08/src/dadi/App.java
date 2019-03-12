/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        
        System.out.println("dimmi quanti soldi hai");
        
        int soldi = s.nextInt();
        
        Giocatore g = new Giocatore(soldi,"pippo");

        Dado dGiocatore = new Dado();
        Dado dBanco = new Dado();

        while (g.getSoldi() > 0) {
            int puntiGiocatore = dGiocatore.lancio();
            int puntiBanco = dBanco.lancio();
            if (puntiGiocatore > puntiBanco) {
                g.incrementa();
            } else {
                g.decrementa();
            }
            stampaMano(puntiBanco, puntiGiocatore, g.getSoldi());
        }
    }
    
     private static void stampaMano(int puntiBanco, int puntiGiocatore, int soldi) {
        System.out.println("---------- giocata ---------------------------");
        System.out.println(String.format("tiro giocatore -> %s , tiro banco -> %s ",
                puntiGiocatore, puntiBanco));
        System.out.println(String.format("soldi giocatore -> %s", soldi));
    }
}
