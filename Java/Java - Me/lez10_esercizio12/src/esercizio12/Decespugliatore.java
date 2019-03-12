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
public class Decespugliatore extends Apparecchiatura {
    private boolean accElettr;

    public Decespugliatore(int numLav, String marca, boolean ae) {
        super(numLav, marca);
        this.accElettr = ae;
    }
}
