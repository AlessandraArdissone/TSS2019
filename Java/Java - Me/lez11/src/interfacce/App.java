/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce;

import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        System.out.println("PERSONE");

        Persona[] persone = {new Persona("Mario", "Rossi")
                , new Persona("Sandro", "Bianchi")
                , new Persona("Giuseppe", "Verdi")};

        System.out.println("--------------ORIGINALE------------");
        System.out.println(Arrays.toString(persone));

        // CLASSE DI UTILITY PER GLI ARRAY
        Arrays.sort(persone);

        System.out.println("--------------ORDINATO-------------");
        System.out.println(Arrays.toString(persone));

        System.out.println("MOTO");

        Moto[] motos = {new Moto(1000)
                , new Moto(750)
                , new Moto(600)};

        System.out.println("--------------ORIGINALE------------");
        System.out.println(Arrays.toString(motos));

        Arrays.sort(motos);

        System.out.println("--------------ORDINATO-------------");
        System.out.println(Arrays.toString(motos));

        System.out.println("--------------LIST-----------------");

        // CLASSE DI UTILITY PER LE LISTE
        List<Persona> listPersone = Arrays.asList(new Persona("Mario", "Rossi")
                , new Persona("Sandro", "Bianchi")
                , new Persona("Giuseppe", "Verdi"));
        Collections.sort(listPersone);
        System.out.println(listPersone);

        System.out.println("---------------STREAM--------------");

        // CLASSE DI UTILITY PER GLI STREAM (FLUSSI)
        Stream.of(new Persona("Mario", "Rossi"), new Persona("Sandro", "Bianchi"),
                new Persona("Giuseppe", "Verdi")).sorted().forEach(p -> System.out.println(p.toString()));
    }
}

class Moto implements Comparable<Moto> {

    private final int cilindrata;

    public Moto(int cilindrata) {
        this.cilindrata = cilindrata;
    }

    public int getCilindrata() {
        return this.cilindrata;
    }

    @Override
    public String toString() {
        return "cilindrata -> " + cilindrata;
    }

    @Override
    public int compareTo(Moto o) {
        return this.cilindrata - o.getCilindrata();
    }
}

class Persona implements Comparable<Persona> {

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
        return this.cognome + " " + this.nome;
    }

    public void vaiALavorare() {
        System.out.println("Ok, ci vado");
    }

    @Override
    public int compareTo(Persona o) {
        return this.cognome.compareTo(o.cognome);
    }
}
