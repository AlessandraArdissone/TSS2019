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
public class Furgone extends Veicolo{
    
    int capacity;

    public Furgone(String marca, int anno, int cilindrata, int capacity) {
        super(marca, anno, cilindrata);
        this.capacity=capacity;
    }

    public int getCapacity() {
        return capacity;
    }
    
    
}
