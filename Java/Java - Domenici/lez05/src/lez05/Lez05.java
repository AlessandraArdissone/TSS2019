/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez05;

/**
 *
 * @author tss
 */
public class Lez05 {

    public static void stampa(int[] array) {
        //foreach
        for (int numero : array) {
            System.out.println(numero);
        }
    }

    //trovare il massimo in un array di numeri
    public static int max(int[] array) {
        int massimo = array[0];
        for (int el : array) {
            if (el > massimo) {
                massimo = el;
            }
        }
        return massimo;
    }

    //ricerca di un numero
    public static boolean cerca(int[] array, int numero) {
        boolean trovato = false;
        int idx = 0;
        do {
            if (array[idx] == numero) {
                trovato = true;
            }
            idx++;
        } while (!trovato && idx < array.length);
        return trovato;
    }

    //estrarre i numeri pari
    public static int[] pari(int[] array) {
        int[] risultato = new int[countPari(array)];
        int idx = 0;
        for (int numero : array) {
            if (isPari(numero)) {
                risultato[idx] = numero;
                idx++;
            }
        }
        return risultato;
    }

    //ordina 
    public static void ordina(int[] array) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int z = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = z;
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }

    public static boolean isPari(int numero) {
        return numero % 2 == 0;
    }

    public static int countPari(int[] array) {
        int risultato = 0;
        for (int numero : array) {
            if (isPari(numero)) {
                risultato++;
            }
        }
        return risultato;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("-------------- start --------------------------------");

        int[] numeri = {34, 2, 67, 56, 89, 2, 32, 134, 15};

        System.out.println(String.format("MAX = %s", max(numeri)));

        System.out.println(String.format("Cerca il numero %s : %s", 15, cerca(numeri, 15)));

        System.out.println(String.format("Cerca il numero %s : %s", 14, cerca(numeri, 14)));

        System.out.println(String.format("---------------------- %s -------------------------", "Numeri PARI"));

        stampa(pari(numeri));

        ordina(numeri);

        System.out.println(String.format("---------------------- %s -------------------------", "Ordinato"));

        stampa(numeri);

        System.out.println("-------------- end ---------------------------------");

    }

}
