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
public class GiocoDadi {
    public static void main(String[] args) {
        /*
        Scanner s = new Scanner(System.in);
        System.out.println("Primo giocatore, come ti chiami?");
        String nome = s.next();
        System.out.println("Quanti soldi hai?");
        Giocatore g1 = new Giocatore(s.nextInt(), nome);

        System.out.println("Secondo giocatore, come ti chiami?");
        nome = s.next();
        System.out.println("Quanti soldi hai?");
        Giocatore g2 = new Giocatore(s.nextInt(), nome);
         */
        Giocatore g1 = creaGiocatore("Primo");
        Giocatore g2 = creaGiocatore("Secondo");

        //Giocatore g = new Giocatore();

        /*
        Dado dGiocatore = new Dado();
        Dado dBanco = new Dado();
         */
        Dado dado = new Dado();

        do {
            /*            
            int ptG = dGiocatore.lancio();
            int ptB = dBanco.lancio();
             */

 /*
            int ptG = dado.lancio();
            int ptB = dado.lancio();
             */
            int ptG1 = dado.lancio();
            int ptG2 = dado.lancio();

            //if (dGiocatore.lancio() > dBanco.lancio()) {
            if (ptG1 != ptG2) {
                if (ptG1 > ptG2) {
                    //g.incrementaSoldi();
                    g1.incrementaSoldi();
                    g2.decrementaSoldi();
                } else {
                    //g.decrementaSoldi();
                    g2.incrementaSoldi();
                    g1.decrementaSoldi();
                }
            }

            //stampaGiocata(ptG, ptB, g.getSoldi(), g.getNome());
            stampaGiocata(ptG1, ptG2, g1.getSoldi(), g2.getSoldi(), g1.getNome(), g2.getNome());
        } while (g1.getSoldi() > 0 && g2.getSoldi() > 0);
        //} while (g.getSoldi() > 0);
    }

    private static Giocatore creaGiocatore(String ordinale) {
        Scanner s = new Scanner(System.in);
        System.out.println(ordinale + " giocatore, come ti chiami?");
        String nome = s.next();
        System.out.println("Quanti soldi hai?");
        return new Giocatore(s.nextInt(), nome);
    }

    /*
    private static void stampaGiocata(int ptG, int ptB, int soldi, String nome) {
        System.out.println("---------------GIOCATA---------------");
        System.out.println("Punti BANCO: " + ptB);
        System.out.println("Punti " + nome + ": " + ptG);
        System.out.println("Soldi: " + soldi);
    }
     */
    private static void stampaGiocata(int ptG1, int ptG2, int soldiG1, int soldiG2, String nomeG1, String nomeG2) {
        System.out.println("--------------- GIOCATA ---------------");
        System.out.println("Punti " + nomeG1 + ": " + ptG1);
        System.out.println("Punti " + nomeG2 + ": " + ptG2);
        System.out.println("Soldi " + nomeG1 + ": " + soldiG1);
        System.out.println("Soldi " + nomeG2 + ": " + soldiG2);
    }
}
