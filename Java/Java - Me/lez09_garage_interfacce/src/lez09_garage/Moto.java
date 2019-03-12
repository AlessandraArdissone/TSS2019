/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez09_garage;

/**
 *
 * @author tss
 */
public class Moto extends Veicolo{

    
    public enum Tempi{
        DUE_T, QUATTRO_T
    }
    
    private final Tempi tempi;
    
    public Moto(String marca, int anno, int cilindrata, Tempi tempi) {
        super(marca, anno, cilindrata);
        this.tempi=tempi;
    }

    public Tempi getTempi() {
        return tempi;
    }
    
    @Override
    public String toString(){
        return super.toString()+ "\n"
                + String.format("tempi %s", this.tempi);
    }
    
}
