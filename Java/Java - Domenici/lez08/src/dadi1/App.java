/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi1;

import java.util.Random;
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
        
        dadi.Giocatore g = new dadi.Giocatore(soldi,"pippo");

        dadi.Dado dGiocatore = new dadi.Dado();
        dadi.Dado dBanco = new dadi.Dado();

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

class Dado {

    public Dado() {

    }

    public int lancio() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

}

class Giocatore {

    private int soldi;
    private String nome;

    public Giocatore(int valore, String nome) {
        if (valore <= 0) {
            throw new IllegalArgumentException("I soldi non possono essere negativi");
        }
        soldi = valore;
        this.nome = nome;
    }

    public void incrementa() {
        soldi++;
    }

    public void decrementa() {
        soldi--;
    }

    public int getSoldi() {
        return soldi;
    }

    public String getNome() {
        return nome;
    }

}

