/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez07;

import java.util.Arrays;

/**
 *
 * @author tss
 */
public class Esercizi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(contaVocali1("ediolognomomongoloide"));

        System.out.println("------------------------------------");

        System.out.println(contaVocali2("ediolognomomongoloide"));

        System.out.println("------------------------------------");

        System.out.println(palindroma1("ediolognomomongoloide"));
        System.out.println(palindroma1("Alessandra"));
        System.out.println(palindroma1("angolobarabologna"));
        System.out.println(palindroma1("itopinonavevanonipoti"));
        System.out.println(palindroma1("Ardissone"));
        System.out.println(palindroma1("goddog"));

        System.out.println("------------------------------------");

        System.out.println(palindroma2("ediolognomomongoloide"));
        System.out.println(palindroma2("Alessandra"));
        System.out.println(palindroma2("angolobarabologna"));
        System.out.println(palindroma2("itopinonavevanonipoti"));
        System.out.println(palindroma2("Ardissone"));
        System.out.println(palindroma2("goddog"));
    }

    //  TORNA IL NUMERO DI VOCALI CONTENUTE IN UNA STRINGA
    public static int contaVocali1(String caratteri) {
        //  indicare quali sono le vocali --> insieme
        String vocali = "aeiou";
        int nVocali = 0;
        //  devo controllare anche le maiuscole, quindi rendo tutto minuscolo!
        caratteri = caratteri.toLowerCase();
        //  scorro tutti i caratteri della stringa in ingresso
        for (int i = 0; i < caratteri.length(); i++) {
            //  carattere per carattere, vedo se appartiene all'insieme delle vocali
            char lettera = caratteri.charAt(i);
            //  se sì, conto +1
            if (vocali.indexOf(lettera) >= 0) {
                nVocali++;
            }
        }
        //  terminati tutti i caratteri della stringa, restituisco il risultato del conteggio
        return nVocali;
    }

    //  TORNA IL NUMERO DI VOCALI CONTENUTE IN UNA STRINGA
    public static int contaVocali2(String caratteri) {
        int nVocali = 0;

        for (int i = 0; i < caratteri.length(); i++) {
            char lettera = caratteri.charAt(i);
            if (isVocale2(lettera)) {
                nVocali++;
            }
        }

        return nVocali;
    }

    private static boolean isVocale2(char lettera) {
        return (lettera == 'a' || lettera == 'e' || lettera == 'i' || lettera == 'o' || lettera == 'u');
        /*        
        String vocali = "aeiou";
        return vocali.indexOf(lettera) >= 0;
        return vocali.contains(Character.toString(lettera));
        char[] vocali = {'a', 'e', 'i', 'o', 'u'};
        return Arrays.binarySearch(vocali, lettera) != -1;
         */
    }

    private static boolean cerca(char[] vocali, char lettera) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //  TORNA TRUE SE LA STRINGA E' PALINDROMA (ES. "OTTO") --> ribalta la stringa e fa un confronto
    public static boolean palindroma1(String caratteri) {
        boolean boolPal = false;

        String ribaltata = inverti(caratteri);
        boolPal = caratteri.equals(ribaltata);

        return boolPal;
    }

    private static String inverti(String caratteri) {
        StringBuilder sb = new StringBuilder();

        for (int i = caratteri.length() - 1; i >= 0; i--) {
            sb.append(caratteri.charAt(i));
        }

        String invertita = sb.toString();

        return invertita;
    }

    //  TORNA TRUE SE LA STRINGA E' PALINDROMA (ES. "OTTO") --> confronta le coppie di caratteri: primo con ultimo, secondo con penultimo, ecc...
    public static boolean palindroma2(String caratteri) {
        for (int i = 0; i < caratteri.length(); i++) {
            if (caratteri.charAt(i) != caratteri.charAt(caratteri.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }
}
