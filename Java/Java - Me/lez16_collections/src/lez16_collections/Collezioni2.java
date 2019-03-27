/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez16_collections;

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
        Integer[] numeri = {89, 78, 125, 7, 36, 11, 0, 36, 41, 28, 125};
        
        Collection<Integer> soloDispari = new Collezioni2().rimuoviPari(Arrays.asList(numeri));

        for (Integer numero : soloDispari) {
            System.out.println(numero);
        }
    }

    /**
     * Deve restituire una nuova collection senza i numeri pari ed i doppioni
     *
     * @param numeri
     * @return
     */
    public Collection<Integer> rimuoviPari(Collection<Integer> numeri) {
        Collection<Integer> result = new HashSet(numeri);
        Iterator<Integer> iterator = result.iterator(); // iterator è l'iterator di result
        
        while (iterator.hasNext()) {
            Integer numero = iterator.next();
            if(isPari(numero))
                iterator.remove();  // se modifico iterator, modifico anche result
        }
        
        return result;
    }
    
    public boolean isPari(Integer n) {
        return (n % 2 == 0);
    }
}
