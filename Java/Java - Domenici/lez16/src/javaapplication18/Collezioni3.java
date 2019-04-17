/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication18;

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

        rubrica.put("mario", 00000000);

        rubrica.putIfAbsent("anna", 3333333);

        System.out.println(rubrica.get("anna"));

        Iterator<String> iterator = new TreeSet<>(rubrica.keySet()).iterator();

        System.out.println("------ chiavi rubrica --------------");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
