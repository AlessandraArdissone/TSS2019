/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez.pkg09.garage;

/**
 *
 * @author tss
 */
public class Veicolo {

    private final String marca;
    private final int anno;
    private final int cilindrata;

    public Veicolo(String marca, int anno, int cilindrata) {
        this.marca = marca;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnno() {
        return anno;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String toString() {
       return String.format("marca %s \t anno %s \t cilindrata %s ",
                this.marca, this.anno, this.cilindrata);
    }
    
    
}
