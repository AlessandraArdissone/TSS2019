/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez04;

/**
 *
 * @author tss
 */
public class Array {

    public static void main(String[] args) {
    //  Dichiarazione di un array di interi:
        int[] numbers;

    //  Creazione dell'array di 100 numeri: (ogni elemento è inizializzato a 0, che è il valore di default)
        numbers = new int[100];

    //  Forma abbreviata 1: (ogni elemento è inizializzato a 0, che è il valore di default)
    //  int[] Numbers = new int[100];

    //  Forma abbreviata 2: (ogni elemento è inizializzato ad un valore definito)
        int[] nrs = {53, 87, 6, 980};
        printIntArray(nrs);
        System.out.println("--------------------------------------------");
/*
        for (int i = 0; i < 100; i++)
        //  System.out.println(numbers[i]);
            System.out.println(String.format("L'elemento num. %s vale: %s.", i, numbers[i]));
*/
        numbers[10] = 42;
        printIntArray(numbers);
        
    //  Carico l'array:
        for (int i = 0; i < 100; i++)
            numbers[i] = i + 1;
        //  System.out.println(numbers[i]);
        //  System.out.println(String.format("L'elemento num. %s vale: %s.", i, numbers[i]));

        System.out.println("--------------------------------------------");
/*        
        for (int i = 0; i < 100; i++)
            System.out.println(String.format("L'elemento num. %s vale: %s.", i, numbers[i]));
*/
        printIntArray(numbers);
    }
    
    public static void printIntArray(int[] array){
        for (int i = 0; i < array.length; i++)
            System.out.println(String.format("L'elemento num. %s vale: %s.", i, array[i]));
    }
}
