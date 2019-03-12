/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez08;

import java.util.Random;

/**
 *
 * @author tss
 */
public class GiocoDadi {

    private static int soldi;
    
    public static void main(String[] args) {

        soldi = 10;

        while (soldi > 0) {
            gioca();
        }
    }

    private static void gioca() {
        int puntiBanco = lanciaDado();
        int puntiGiocatore = lanciaDado();

        if (puntiGiocatore > puntiBanco) {
            soldi++;
        } else {
            soldi--;
        }
        stampaMano(puntiBanco, puntiGiocatore);
    }

    private static void stampaMano(int puntiBanco, int puntiGiocatore) {
        System.out.println("---------- giocata ---------------------------");
        System.out.println(String.format("tiro giocatore -> %s , tiro banco -> %s ",
                puntiGiocatore, puntiBanco));
        System.out.println(String.format("soldi giocatore -> %s", soldi));
    }

    private static int lanciaDado() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

}
