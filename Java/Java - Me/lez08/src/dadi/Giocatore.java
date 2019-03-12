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
    
    public Giocatore() {
        soldi = 10;
    }
    
    public Giocatore(int importo, String nome) {
        if (importo <= 0) {
            throw new IllegalArgumentException("PER GIOCARE DEVI AVERE I SOLDI!");
        }
        soldi = importo;
        this.nome = nome;
    }
    
    public int getSoldi() {
        return soldi;
    }

    public void setSoldi(int importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("PER GIOCARE DEVI AVERE I SOLDI!");
        }
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
