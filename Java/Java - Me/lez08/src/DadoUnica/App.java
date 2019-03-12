/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DadoUnica;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        Giocatore g1 = creaGiocatore("Primo");
        Giocatore g2 = creaGiocatore("Secondo");
        Dado dado = new Dado();

        do {
            int ptG1 = dado.lancio();
            int ptG2 = dado.lancio();

            if (ptG1 != ptG2) {
                if (ptG1 > ptG2) {
                    g1.incrementaSoldi();
                    g2.decrementaSoldi();
                } else {
                    g2.incrementaSoldi();
                    g1.decrementaSoldi();
                }
            }

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

class Dado {
    public Dado() {
        //
    }
    
    public int lancio() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}

class Giocatore {
    private int soldi;
    private String nome;
    
    public Giocatore() {
        soldi = 10;
    }
    
    public Giocatore(int portafoglio, String nome) {
        if (portafoglio <= 0) {
            throw new IllegalArgumentException("Il banco NON fa CREDITO!");
        }
        soldi = portafoglio;
        this.nome = nome;
    }
    
    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(int importo) {
        soldi = importo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void incrementaSoldi() {
        soldi++;
    }
    
    public void decrementaSoldi() {
        soldi--;
    }
}
