/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lex07;

import java.util.Arrays;

/**
 *
 * @author tss
 */
public class Esercizi {

    public static void main(String[] args) {
        int numeroVocali = contaVocali("abcwdfn  12qwkpnwopifnwoefqeodfnqeiopdfn    eipfn   epifn   epdfn   ep");
        System.out.println("Numero vocali -> " + numeroVocali);
        System.out.println(palindroma1("ottobon"));;
    }

    /**
     * Torna il numero di vocali di una Stringa
     *
     * start
     *      caratteri = parola in input
     *      conta = 0
     *      per ogni lettera di caratteri
     *          se lettera è vocale
     *              conta++
     *      return conta
     * end
     * 
     * @param caratteri
     * @return
     */
    public static int contaVocali(String caratteri) {

        int conta = 0;
        for (int i = 0; i < caratteri.length(); i++) {
            char lettera = caratteri.charAt(i);
            if(isVocale(lettera)){
                conta ++;
            }
        }
        return conta;
    }

    private static boolean isVocale(char lettera) {
        return lettera == 'a' || lettera == 'e' || lettera == 'i' || lettera== 'o' || lettera=='u';
    }

    private static boolean isVocale1(char lettera) {
        String vocali = "aeiou";
        return vocali.indexOf(lettera)!=-1;
    }
    
    private static boolean isVocale2(char lettera) {
        String vocali = "aeiou";
        return vocali.contains(Character.toString(lettera));
    }
    
    private static boolean isVocale3(char lettera) {
        char[] vocali = {'a','e', 'i','o','u'};
        return Arrays.binarySearch(vocali, lettera) != -1;
    }
    
    /**
     *
     * Torna vero se la frase è palindroma Es. otto start caratteri = parola da
     * verificare ribaltata = caratteri invertita al contrario per -> rep se
     * caratteri = ribaltata allora return true altrimenti return false end end
     *
     * @param caratteri
     * @return
     */
    public static boolean palindroma(String caratteri) {
        String ribaltata = inverti(caratteri);
        return caratteri.equals(ribaltata);
    }

    /**
     *
     * Torna vero se la frase è palindroma Es. otto 
     * start 
     *      caratteri = parola da verificare 
     *      per ogni coppia di caratteri se coppia è diversa return non
     *      palindroma altrimenti 
     * end
     *
     * @param caratteri
     * @return
     */
    public static boolean palindroma1(String caratteri) {
        for (int i = 0; i < caratteri.length() - 1; i++) {
            if (caratteri.charAt(i) != caratteri.charAt(caratteri.length() - (i + 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * inverte una stringa
     *
     * @param caratteri
     * @return
     */
    private static String inverti(String caratteri) {
        StringBuilder sb = new StringBuilder();
        for (int i = caratteri.length() - 1; i >= 0; i--) {
            sb.append(caratteri.charAt(i));
        }
        return sb.toString();
    }

    
}
