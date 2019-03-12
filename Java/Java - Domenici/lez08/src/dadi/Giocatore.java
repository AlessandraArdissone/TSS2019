/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dadi;

/**
 *
 * @author tss
 */
public class Giocatore {

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
