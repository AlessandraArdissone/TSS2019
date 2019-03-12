/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez08;

/**
 *
 * @author tss
 */
public class GiocoDadi {

    static int soldi;
    private static int dB;
    private static int dG;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        soldi = 10;

        do {
            gioca();
            stampaGiocata();
        } while (soldi > 0);
    }

    private static void gioca() {
        dB = lanciaDado();
        dG = lanciaDado();

        if (dB < dG) {
            soldi++;
        } else {
            soldi--;
        }
    }

    private static int lanciaDado() {
        return (int) (6 * Math.random()) + 1;
    }

    private static void stampaGiocata() {
        System.out.println("---------------GIOCATA---------------");
        System.out.println("Punti BANCO: " + dB);
        System.out.println("Punti GIOCATORE: " + dG);
        System.out.println("Soldi: " + soldi);
    }
}
