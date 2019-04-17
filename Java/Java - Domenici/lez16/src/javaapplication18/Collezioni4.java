/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author tss
 */
public class Collezioni4 {

    public static void main(String[] args) {

        Integer[] numeri = {20, 3, 5, 7, 12, 45, 12, 90, 90};

        List<Integer> listNumeri = Arrays.asList(numeri);

        listNumeri
                .stream()
                .distinct()
                .filter(numero -> numero % 2 == 0)
                .map(Collezioni4::calcola)
                .forEach(System.out::println);

    }

    private static long calcola(int n) {
        return n * n;
    }
}
