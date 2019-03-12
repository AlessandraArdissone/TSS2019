/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez10_esercizio05;

/**
 *
 * @author tss - Alessandra
 */
public class Orario {

    private int ore, minuti, secondi;

    public Orario(int ore, int minuti, int secondi) {
        valida(ore, minuti, secondi);
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
    }

    public boolean valida(int ore, int minuti, int secondi) {
        if (ore < 0 || ore > 23) {
            throw new IllegalArgumentException("ore non valide");
        }
        if (minuti < 0 || minuti > 59) {
            throw new IllegalArgumentException("minuti non validi");
        }
        if (secondi < 0 || secondi > 59) {
            throw new IllegalArgumentException("secondi non validi");
        }
        return false;
    }

    public void aggiungi(int ore, int minuti, int secondi) {
        valida(ore, minuti, secondi);

        if (this.secondi + secondi > 59) {
            this.minuti++;
            this.secondi = (this.secondi + secondi) % 60;
        } else {
            this.secondi += secondi;
        }

        if (this.minuti + minuti > 59) {
            this.ore++;
            this.minuti = (this.minuti + minuti) % 60;
        } else {
            this.minuti += minuti;
        }

        this.ore = (this.ore + ore) % 24;
    }

    public void sottrai(int ore, int minuti, int secondi) {
        valida(ore, minuti, secondi);

        if (this.secondi - secondi < 0) {
            this.minuti--;
            this.secondi = (this.secondi - secondi) % 60;
        } else {
            this.secondi -= secondi;
        }

        if (this.minuti - minuti < 0) {
            this.ore--;
            this.minuti = (this.minuti - minuti) % 60;
        } else {
            this.minuti -= minuti;
        }

        if (this.ore - ore < 0) {
            this.ore = 24 - ore;
        } else {
            this.ore -= ore;
        }
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", this.ore, this.minuti, this.secondi);
    }
}
