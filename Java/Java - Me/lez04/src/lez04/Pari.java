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
public class Pari {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Inserisci un numero: ");
        int n = s.nextInt();

//      CASTING AUTOMATICO: in caso di numero dispari, assegna a result SOLO LA PARTE INTERA, poiché result è di tipo intero:
//      int result = n / 2;
//      IDEM, poiché è una divisione tra due interi:
//      float result = n / 2;
//      ora la divisione è tra un intero ed un float (2 è castato):
/*
        float result = n / 2f;
        
        System.out.println(String.format("result contiene: %s", result));
         */
//      L'operatore matematico % restituisce il resto di una divisione:
        int remain = n % 2;

        if (remain == 0)
            System.out.println(String.format("Il numero %s è pari.", n));
        else
            System.out.println(String.format("Il numero %s è dispari.", n));
    }
}
