/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio12;

/**
 *
 * @author tss - Alessandra
 */
public class Motozappa extends Apparecchiatura {

    private int nRuote;

    public Motozappa(int numLav, String marca, int numR) {
        super(numLav, marca);
        this.nRuote = numR;
    }
}
