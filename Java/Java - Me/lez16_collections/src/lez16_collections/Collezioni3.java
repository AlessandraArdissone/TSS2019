/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez16_collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

/**
 *
 * @author tss
 */
public class Collezioni3 {

    public static void main(String[] args) {
        Map<String, Integer> rubrica = new HashMap<>();

        rubrica.put("anna", 123456789);
        rubrica.put("mario", 987654321);
        rubrica.putIfAbsent("anna", 333333333);

        System.out.println(rubrica.get("anna"));

        System.out.println("-------------chiavi rubrica-------------");

        //Iterator<String> iterator = rubrica.keySet().iterator();

        //Iterator<String> iterator = new TreeSet<String>(rubrica.keySet()).iterator();
        Iterator<String> iterator = new TreeSet<>(rubrica.keySet()).iterator();
        //Iterator<String> iterator = new TreeSet(rubrica.keySet()).iterator();

        while (iterator.hasNext()) {
            String nome = iterator.next();
            System.out.println(nome + ": " + rubrica.get(nome));
        }
    }
}
