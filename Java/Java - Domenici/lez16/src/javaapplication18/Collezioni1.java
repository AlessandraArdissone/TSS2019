/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

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

    public static void main(String[] args) {
        
        
        Integer[] numeri = {20,3,5,7,12,45,12,90,90};
        
        List<Integer> listNumeri = Arrays.asList(numeri);

        Set<Integer> setNumeri = new HashSet(listNumeri);
        
        System.out.println("----- for each ------");
        
        for(Integer numero : numeri){
            System.out.println(numero);
        }
        
        System.out.println("----- iterator ------");
        
        Iterator<Integer> iterator = setNumeri.iterator();
        
        while(iterator.hasNext()){
            Integer numero = iterator.next();
            System.out.println(numero);
        }

    }

}
