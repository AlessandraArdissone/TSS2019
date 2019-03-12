/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lex07;

/**
 *
 * @author tss
 */



public class Lez07 {


    private static String msg = "sono visibile da tutta la classe";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a = 10;

        int b = a;

        b = 20;

        //array
        int[] a1 = {10, 20};

        int[] b1 = a1;

        b1[0] = 50;

        System.out.println(a1[0]); // ??? stampa 50

        String a2 = "tss";

        String b2 = "tss";

        String c2 = new String("tss");

        System.out.println(a2 == c2); //??? true da spiegare

        System.out.println(msg);
        
        System.out.println("b".compareTo("b"));
    }

    public static void f1() {

        System.out.println(msg);
        
        
        if(msg == null){
            int x = 0;
        }
        
        int x = 10;
        System.out.println(x);
        
        
        {
            
            //int x = 10;
        }
    }
}
