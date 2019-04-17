/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        List<Carta> mazzo = creaMazzo();

        System.out.println(Carta.getCount());
        
        System.out.println(mazzo.
                contains(new Carta(Carta.Seme.CUORI, 10)));
    }

    private static List<Carta> creaMazzo() {
        List<Carta> result = new ArrayList<>();
        EnumSet<Carta.Seme> semi = EnumSet.allOf(Carta.Seme.class);
        for (Carta.Seme seme : semi) {
            for (int i = 1; i <= 13; i++) {
                result.add(new Carta(seme, i));
            }
        }
        return result;
    }

}

class Carta {

    //proprietà statica o di classe
    private static int count = 0;

    //proprietà di istanza
    private final Seme seme;

    private final int valore;

    private final String nome;

    public static enum Seme {
        CUORI, QUADRI, FIORI, PICCHE
    }

    public Carta(Seme seme, int valore) {
        this(seme, valore, "");
        count++;
    }

    public Carta(Seme seme, int valore, String nome) {
        this.seme = seme;
        this.valore = valore;
        this.nome = nome;
    }

    public void disegna() {
        System.out.println("carta x....");
    }

    /*
    get e set
     */
    public static int getCount() {
        return count;
    }

    public Seme getSeme() {
        return seme;
    }

    public int getValore() {
        return valore;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.seme);
        hash = 53 * hash + this.valore;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carta other = (Carta) obj;
        if (this.valore != other.valore) {
            return false;
        }
        return this.seme == other.seme;
    }

    
    @Override
    public String toString() {
        return "Carta{" + "seme=" + seme + ", valore=" + valore + ", nome=" + nome + '}';
    }

}
