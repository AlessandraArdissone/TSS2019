/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez16_collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Collezioni0 {

    public static void main(String[] args) {

        List persone
                = Arrays.asList(
                        new Person("mario",
                                LocalDate.parse("20/12/2000")),
                        new Person("anna",
                                LocalDate.parse("02/11/1998")));

        Object o = persone.get(0);

        Person p = (Person) o;

    }
}

class Person {

    String nome;
    LocalDate nascita;

    public Person(String nome, LocalDate nascita) {
        this.nome = nome;
        this.nascita = nascita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascita() {
        return nascita;
    }

    public void setNascita(LocalDate nascita) {
        this.nascita = nascita;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.nascita);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.nascita, other.nascita)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "nome=" + nome + ", nascita=" + nascita + '}';
    }
}
