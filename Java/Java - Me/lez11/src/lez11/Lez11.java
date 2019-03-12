/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez11;

/**
 *
 * @author tss
 */
public class Lez11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Object o = new Object();
        System.out.println(o);
         */
        Persona p = new Persona("Mario", "Rossi");
        /*
        System.out.println(p);
        System.out.println(p.toString());
         */
        p.vaiALavorare();
        stampa(p);

        Moto m = new Moto(600);
        stampa(m);
    }

    // se come Object gli passo una Persona, mi richiama il metodo toString di Persona, NON di Object!!!!
    // se come Object gli passo una Moto, mi richiama il metodo toString di Moto, NON di Object!!!!
    //////////////////////////////////////////////
    // POLIMORFISMO!!!!!!!!!!!!!!!!!!!!!!!!!    //
    //////////////////////////////////////////////
    private static void stampa(Object o) {
        //System.out.println(o.toString());
        System.out.println(o);
    }
}

class Moto {

    private final int cilindrata;

    public Moto(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return this.cilindrata;
    }

    @Override
    public String toString() {
        return "Moto{" + "cilindrata=" + cilindrata + '}';
    }
}

class Persona {

    private final String nome, cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    @Override // ANNOTAZIONE
    public String toString() {
        // return super.toString();
        return String.format("nome-> %s, cognome-> %s", this.nome, this.cognome);
    }

    public void vaiALavorare() {
        System.out.println("Ok, ci vado");
    }
}
