/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        /*
        -------------- Arrays ---------------------------
         */
        System.out.println("---------Ordinamento Array------------------");
        Persona[] persone = {new Persona("mario", "rossi"),
            new Persona("sandro", "bianchi"),
            new Persona("giuseppe", "verdi")};

        Arrays.sort(persone);

        System.out.println(Arrays.toString(persone));

        Moto[] motos = {new Moto(1000), new Moto(500), new Moto(750)};

        Arrays.sort(motos);

        System.out.println(Arrays.toString(motos));

        /*
        -------------- Liste ---------------------------
         */
        System.out.println("---------Ordinamento Liste------------------");
        List<Persona> listPersone = Arrays.asList(new Persona("mario", "rossi"),
                new Persona("sandro", "bianchi"),
                new Persona("giuseppe", "verdi"));

        Collections.sort(listPersone);

        System.out.println(listPersone);

        /*
        -------------- Stream ---------------------------
         */
        System.out.println("---------Ordinamento Stream------------------");

        Stream.of(new Persona("mario", "rossi"),
                new Persona("sandro", "bianchi"),
                new Persona("giuseppe", "verdi"))
                .sorted()
                .forEach(p -> System.out.println(p.toString()));
    }
}

class Moto implements Comparable<Moto> {

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

    @Override
    public int compareTo(Moto o) {
        return cilindrata - o.getCilindrata();
    }

}

class Persona implements Comparable<Persona> {

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
        return cognome + " " + nome;
    }

    @Override
    public int compareTo(Persona o) {
        return this.cognome.compareTo(o.getCognome());
    }

}
