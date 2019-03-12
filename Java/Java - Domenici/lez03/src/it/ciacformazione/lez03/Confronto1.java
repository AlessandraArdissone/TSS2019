/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.ciacformazione.lez03;

import java.util.Scanner;

/**
 *
 * @author tss
 */
public class Confronto1 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        System.out.println("Inserisci il primo numero: ");
        int op1 = s.nextInt();

        System.out.println("Inserisci il secondo numero: ");
        int op2 = s.nextInt();

        if (op1 > op2) {
            System.out.println(op1);
        } else if (op2 > op1) {
            System.out.println(op2);
        } else {
            System.out.println("uguali");
        }

    }
}
