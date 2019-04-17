/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 *
 * @author tss
 */
public class Collezioni2 {

    public static void main(String[] args) {
        Integer[] numeri = {20, 3, 5, 7, 12, 45, 12, 90, 90};

        Collection<Integer> soloDispari = new Collezioni2()
                .rimuoviPari(Arrays.asList(numeri));
        
        for (Integer numero : soloDispari) {
            System.out.println(numero);
        }
    }

    /*
        Ritornare una nuova collection senza i numeri pari
     */
    public Collection<Integer> rimuoviPari(Collection<Integer> numeri) {
        Collection<Integer> result = new HashSet(numeri);
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()) {
            Integer numero = iterator.next();
            if (numero % 2 == 0) {
                iterator.remove();
            }
        }
        return result;
    }
}
