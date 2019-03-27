/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez16_collections;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tss
 */
public class Collezioni4 {

    public static void main(String[] args) {
        Integer[] numeri = {89, 78, 125, 7, 36, 11, 0, 36, 41, 28, 125};
        List<Integer> listNumeri = Arrays.asList(numeri);

        listNumeri
                .stream()
                .distinct() // elimina i duplicati
                .filter(numero -> isPari(numero))   // lambda function/expression
                //.map(numero -> numero * numero)
                //.map(numero -> quadrato(numero))
                .map(Collezioni4::quadrato) // method reference
                //.forEach(numero -> System.out.println(numero));
                .forEach(System.out::println);  // method reference
    }

    private static boolean isPari(Integer n) {
        return (n % 2 == 0);
    }

    private static long quadrato(Integer n) {
        return (n * n);
    }
}
