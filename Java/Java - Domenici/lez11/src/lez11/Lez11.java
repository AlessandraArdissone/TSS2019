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

        Persona p = new Persona("mario", "rossi");

        stampa(p);

        Moto m = new Moto(600);

        stampa(m);

    }

    private static void stampa(Object o) {
        System.out.println(o);
    }
}

class Moto {

    private final int cilindrata;

    public Moto(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String toString() {
        return "cilindrata -> " + cilindrata;
    }

}

class Persona {

    private final String nome, cognome;

    public Persona(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void vaiALavorare() {
        System.out.println("ok...ci vado");
    }

    @Override
    public String toString() {
        return String.format("nome-> %s , cognome-> %s", this.nome, this.cognome);
    }

}


