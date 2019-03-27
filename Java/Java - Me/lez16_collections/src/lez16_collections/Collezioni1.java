/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez16_collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tss
 */
public class Collezioni1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] numeri = {89, 78, 125, 7, 36, 11, 0, 36, 41, 28, 125};
        
        List<Integer> listNumeri = Arrays.asList(numeri);

        Set<Integer> setNumeri = new HashSet(listNumeri);

        System.out.println("---------for each---------");

        for (Integer numero : numeri) {
            System.out.println(numero);
        }

        System.out.println("---------iterator---------");

        Iterator<Integer> iterator = setNumeri.iterator();

        while (iterator.hasNext()) {
            Integer numero = iterator.next();
            System.out.println(numero);
        }
    }
}
