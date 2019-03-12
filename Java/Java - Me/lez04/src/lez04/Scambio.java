/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lez04;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Scambio { public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Inserisci il primo numero: ");
        int n1 = s.nextInt();
        
        System.out.println("Inserisci il secondo numero: ");
        int n2 = s.nextInt();
        
        System.out.println("Il primo numero inserito è: " + n1);
        System.out.println("Il secondo numero inserito è: " + n2);        

        int z = n1;
        
        n1 = n2;
        n2 = z;
        
        System.out.println("Il primo numero è diventato: " + n1);
        System.out.println("Il secondo numero è diventato: " + n2);        
//      System.out.println(String.format("Il primo numero è diventato: %s, il secondo numero è diventato: %s.", n1, n2));
    }
    
}
