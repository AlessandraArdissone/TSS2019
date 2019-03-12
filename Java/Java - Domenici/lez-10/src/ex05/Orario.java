/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex05;

/**
 *
 * @author tss
 */
public class Orario {

    private int ore, minuti, secondi;

    public Orario(int ore, int minuti, int secondi) {
        valida(ore, minuti, secondi);
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    public final void valida(int ore, int minuti, int secondi) {
        if (ore < 0 || ore > 23) {
            throw new IllegalArgumentException("ore non valide");
        }
        if (minuti < 0 || minuti > 59 || secondi < 0 || secondi > 59) {
            throw new IllegalArgumentException("minuti o secondi non valide");
        }
    }

    public void aggiungi(Orario o) {
        this.aggiungi(o.getOre(), o.getMinuti(), o.getSecondi());
    }

    public void aggiungi(int ore, int minuti, int secondi) {
        valida(ore, minuti, secondi);
        this.secondi += secondi;
        this.minuti += minuti;
        this.ore += ore;

        if (this.secondi + secondi > 59) {
            this.minuti++;
            this.secondi = (this.secondi + secondi) % 60;
        }

        if (this.minuti + minuti > 59) {
            this.ore++;
            this.minuti = (this.minuti + minuti) % 60;
        }

        this.ore = (this.ore + ore) % 24;

    }

    public void sottrai(int ore, int minuti, int secondi) {
        valida(ore, minuti, secondi);
        this.secondi -= secondi;
        this.minuti -= minuti;
        this.ore -= ore;

        if (this.secondi - secondi < 0) {
            this.minuti--;
            this.secondi = Math.abs(this.secondi % 60);
        }

        if (this.minuti - minuti < 0) {
            this.ore--;
            this.minuti = Math.abs(this.minuti % 60) ;
        }

        if (this.ore - ore < 0) {
            this.ore = Math.abs(this.ore % 24);
        }
        
    }

    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.ore, this.minuti, this.secondi);
    }

}
