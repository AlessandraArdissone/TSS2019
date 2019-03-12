/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez05;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Lez05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] values = {486, 8, 0, 77, 1492, 5, 27, 416, 328, 17};
//        int[] values = {485, 9, 1, 77, 1495, 7, 29, 417, 321, 17};

        print(values);

        System.out.println("--------------------------------------------");

        System.out.println("Il valore massimo è: " + maxValue(values));

        System.out.println("--------------------------------------------");

        Scanner s = new Scanner(System.in);
        System.out.println("Inserisci un numero: ");
        /*
        if (findValue(values, s.nextInt()))
            System.out.println("TROVATO!");
        else
            System.out.println("NON TROVATO!");
         */
        int entry = s.nextInt();
        int pos = findValue(values, entry);
        if (pos >= 0) {
            System.out.println("Il numero " + entry + " è stato trovato alla posizione n. " + (pos - 1) + ".");
        } else {
            System.out.println("Il numero " + entry + " non è stato trovato.");
        }

        System.out.println("--------------------------------------------");

        System.out.println("Numeri pari contenuti nell'array:");
        print(evenNumbers(values));

        System.out.println("--------------------------------------------");

        System.out.println("Array ordinato:");
        sort(values);
    }

    public static void print(int[] array) {
        /*
        for (int i = 0; i > array.length;i++) {
            int element = array[i];
            System.out.println(element);
        }
         */
        //  Altro modo di ciclare su di una struttura, statica o dinamica (corrisponde al forEach di JavaScript)
        for (int el : array) {
            System.out.println(el);
        }
    }

    //  Trovare il massimo (il valore più grande) in un array di numeri:
    public static int maxValue(int[] array) {
        int max = 0;

        for (int nr : array) {
            if (nr > max) {
                max = nr;
            }
        }

        return max;
    }

    //  Ricercare un dato numero all'interno di un array, restituendo l'esito della ricerca:
/*    public static boolean findValue(int[] array, int value) {
        boolean found = false;
        int i = 0;

        while (!found && i < array.length) {
            if (array[i] == value) {
                found = true;
            }
            i++;
        }

        if (found) {
            System.out.println("Il numero " + value + " è stato trovato alla posizione n. " + (i - 1) + ".");
        } else {
            System.out.println("Il numero " + value + " non è stato trovato.");
        }

        return found;
    }*/
    public static int findValue(int[] array, int value) {
        boolean found = false;
        int i = 0;

        while (!found && i < array.length) {
            if (array[i] == value) {
                found = true;
            }
            i++;
        }

        if (found) {
            return i;
        } else {
            return -1;
        }
    }

    //  Estrarre i numeri pari, mostrandoli in un nuovo array:
    public static int[] evenNumbers(int[] array) {
        int even = 0;

        for (int nr : array) {
            if ((nr % 2) == 0) {
                even += 1;
            }
        }

        int evenNrs[] = new int[even];

        if (even > 0) {
            int j = 0;

            for (int nr : array) {
                if ((nr % 2) == 0) {
                    evenNrs[j] = nr;
                    j++;
                }
            }
        }

        return evenNrs;
    }

    //  Ordinare un array:
    public static void sort(int[] array) {
        int swap = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[i]) {
                    swap = array[i];
                    array[i] = array[j];
                    array[j] = swap;
                }
            }
        }
        print(array);
    }
}
