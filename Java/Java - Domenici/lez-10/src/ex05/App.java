/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex05;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        Orario orario = new Orario(23, 10, 0);

        System.out.println(orario);

        orario.aggiungi(1, 20, 0);

        System.out.println(orario);

        orario.sottrai(2, 22, 0);

        System.out.println(orario);

    }
}
